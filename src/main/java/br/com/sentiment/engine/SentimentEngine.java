package br.com.sentiment.engine;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import br.com.sentiment.model.AnalizeResult;
import br.com.sentiment.model.StatisticAnalizeResult;

public class SentimentEngine {
	
	private Map<String, Integer> dicionary;
    private List<String> documents;
    Logger logger = Logger.getLogger(SentimentEngine.class);
	
	public SentimentEngine(List<String> documents, Map<String, Integer> dicionary) {
		this.documents = documents;
		this.dicionary = dicionary;
	}
	
	public AnalizeResult analyze() {
		logger.info("analizing... " );
		Integer negative = new Integer(0);
		Integer positive = new Integer(0);
		
		for (Map.Entry<String, Integer> entry : dicionary.entrySet()) {
		    String wordKey = entry.getKey();
		    Integer weightValue = entry.getValue();
		    
		    for (String document : documents) {
		    	document = document.replaceAll("[.]", "");
		    	document = document.replaceAll("[,]", "");
		    	String[] words = document.split("\\s+");

		    	for (String word : words) {
		    		if (word.equalsIgnoreCase(wordKey)){
						if (weightValue > 0){
							positive += weightValue;
						} else {
							negative += weightValue;
						}
					}
				}
			}
		}
		return new AnalizeResult(negative, positive);

	}
	
	public StatisticAnalizeResult statisticAnalyze() {
		logger.info("analizing... " );
		
		Integer negative = new Integer(0);
		Integer positive = new Integer(0);
		Double count = new Double(0D);
		Double countNegative = new Double(0D);
		Double countPositive = new Double(0D);
		
		
		for (Map.Entry<String, Integer> entry : dicionary.entrySet()) {
		    String wordKey = entry.getKey();
		    Integer weightValue = entry.getValue();
		    
		    for (String document : documents) {
		    	document = document.replaceAll("[.]", "");
		    	document = document.replaceAll("[,]", "");
		    	String[] words = document.split("\\s+");

		    	for (String word : words) {
		    		if (word.equalsIgnoreCase(wordKey)){
		    			count = count + 1;
						if (weightValue > 0){
							positive += weightValue;
							countPositive = countPositive + 1;
						} else {
							negative += weightValue;
							countNegative = countNegative + 1;
						}
					}
				}
			}
		}
	
		return new StatisticAnalizeResult(negative, positive, count, countNegative, countPositive);

	}
	
}
