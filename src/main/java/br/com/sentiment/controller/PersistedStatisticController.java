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
import br.com.sentiment.model.StatisticAnalizeResult;
import br.com.sentiment.persistence.Persister;
import br.com.sentiment.readers.TwitterReader;

@Path("/pstatistic")
@Resource
public class PersistedStatisticController {
	
	protected Result result;
	private final TwitterReader reader;
	private final LoadDicionary dicionaryLoader;
	private final Persister persister;
	Logger logger = Logger.getLogger(PersistedStatisticController.class);
	
	public PersistedStatisticController(Result result, TwitterReader reader, LoadDicionary dicionaryLoader, Persister persister) {
		this.result = result;
		this.reader = reader;
		this.dicionaryLoader = dicionaryLoader;
		this.persister = persister;
	}
    
	@Path("/{queryTerm}")
	public void index(String queryTerm) {
		logger.info("queryTerm: " + queryTerm );
		
		if (queryTerm != null && !queryTerm.isEmpty()) {
			logger.info("queryTerm: " + queryTerm );
			Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
			
			List<String> documents = reader.readTweets(queryTerm);
			SentimentEngine engine = new SentimentEngine(queryTerm, documents, dicionary);
			
			StatisticAnalizeResult statisticAnalizeResult = engine.statisticAnalyze();
			persister.saveEntity(statisticAnalizeResult);
			logger.info("analizeResult: " + statisticAnalizeResult );
			result.include("statisticAnalizeResult", statisticAnalizeResult);
		} else {
			StatisticAnalizeResult statisticAnalizeResult = new StatisticAnalizeResult("", 0, 0, 0D, 0D, 0D);
			result.include("statisticAnalizeResult", statisticAnalizeResult);
		}	
	}
}