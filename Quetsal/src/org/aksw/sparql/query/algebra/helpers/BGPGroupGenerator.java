package org.aksw.sparql.query.algebra.helpers;

import java.util.HashMap;
import java.util.List;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.algebra.StatementPattern;
import org.openrdf.query.algebra.TupleExpr;
import org.openrdf.query.algebra.helpers.StatementPatternCollector;
import org.openrdf.query.parser.ParsedQuery;
//import org.openrdf.query.parser.sparql.SPARQLParser;
/**
 * Generate basic graph patterns also called Disjunctive Normal Form (DNF) groups from a SPARQL query
 * @author Saleem
 *
 */
public class BGPGroupGenerator 

{
	/**
	 * Generate BGP groups from a SPARQL query
	 * @param parsedQuery2 TupleExpr of the SPARQL query
	 * @return DNFGrps Map of DNF groups
	 * @throws MalformedQueryException Query exception
	 */
	public static HashMap<Integer, List<StatementPattern>>  generateBgpGroups(ParsedQuery parsedQuery) throws MalformedQueryException
	{
		HashMap<Integer, List<StatementPattern>> bgpGrps = new HashMap<Integer, List<StatementPattern>>();
	     int grpNo = 0;
	       TupleExpr query = parsedQuery.getTupleExpr();
		// collect all basic graph patterns
		for (TupleExpr bgp : BasicGraphPatternExtractor.process(query)) {
			List<StatementPattern> patterns = StatementPatternCollector.process(bgp);	
			bgpGrps.put(grpNo, patterns );
			grpNo++;
			}
		
		return bgpGrps;
	   }
	
}
