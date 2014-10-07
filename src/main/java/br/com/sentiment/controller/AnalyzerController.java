package br.com.sentiment.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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
public class AnalyzerController {
	
	protected Result result;
	private final TwitterReader reader;
	private final LoadDicionary dicionaryLoader;
	
	Logger logger = Logger.getLogger(AnalyzerController.class);
	
	public AnalyzerController(Result result, TwitterReader reader, LoadDicionary dicionaryLoader) {
		this.result = result;
		this.reader = reader;
		this.dicionaryLoader = dicionaryLoader;
	}
    
	@Path("/{queryTerm}")
	public void index(String queryTerm) {
		logger.info("queryTerm: " + queryTerm );
		
		if (queryTerm != null && !queryTerm.isEmpty()) {
			logger.info("queryTerm: " + queryTerm );
			Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
			
			List<String> documents = reader.readTweets(queryTerm);
			SentimentEngine engine = new SentimentEngine(documents, dicionary);
			
			AnalizeResult analizeResult = engine.analyze();
			logger.info("analizeResult: " + analizeResult );
			result.include("analizeResult", analizeResult);
		} else {
			AnalizeResult analizeResult = new AnalizeResult(0, 0);
			result.include("analizeResult", analizeResult);
		}	
	}
}