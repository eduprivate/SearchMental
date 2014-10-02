package br.com.sentiment.engine;

import java.util.List;
import java.util.Map;

import br.com.sentiment.model.AnalizeResult;

public class SentimentEngine {
	
	private Map<String, Integer> dicionary;
    private List<String> documents;
	
	public SentimentEngine(List<String> documents, Map<String, Integer> dicionary) {
		this.documents = documents;
		this.dicionary = dicionary;
	}
	
	public AnalizeResult analyze() {
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
	
}
