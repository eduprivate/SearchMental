package br.com.sentiment.controller;

import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.sentiment.dicionary.DicionaryType;
import br.com.sentiment.dicionary.LoadDicionary;
import br.com.sentiment.engine.SentimentEngine;
import br.com.sentiment.model.AnalizeResult;
import br.com.sentiment.readers.TwitterReader;

@Path("/analyzer")
@Resource
public class SearchMentalAnalyzer {
	
	protected Result result;
	
	public SearchMentalAnalyzer(Result result) {
		this.result = result;
	}
    
	@Path("/{queryTerm}")
	public void index(String queryTerm) {
		
		if (queryTerm != null && queryTerm.isEmpty()) {
			
			TwitterReader reader = new TwitterReader();
			LoadDicionary dicionaryLoader = new LoadDicionary();
			Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
			
			List<String> documents = reader.readTweets(queryTerm);
			SentimentEngine engine = new SentimentEngine(documents, dicionary);
			
			AnalizeResult analizeResult = engine.analyze();
			result.include("result", analizeResult);
		} else {
			AnalizeResult analizeResult = new AnalizeResult(0, 0);
			result.include("result", analizeResult);
		}
		
		
	}
	
}
