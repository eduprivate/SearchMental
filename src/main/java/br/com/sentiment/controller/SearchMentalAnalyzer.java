package br.com.sentiment.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Path("/analyzer")
@Resource
public class SearchMentalAnalyzer {
    
	@Path("/{queryTerm}")
	public void index(String queryTerm) {
		
	}
	
}
