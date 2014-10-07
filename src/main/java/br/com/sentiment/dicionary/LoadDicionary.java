package br.com.sentiment.dicionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class LoadDicionary {
	
    public LoadDicionary() {
	}
    
    public Map<String, Integer> getDicionaryMap(DicionaryType dicionaryType) {
    	if (dicionaryType == DicionaryType.LOCAL) {
    		return getLocalDicionaryMap();
    	}
    	else if (dicionaryType == DicionaryType.DB){
    		return getLocalDicionaryMap();
    	}
    	return null;
    }
    
    private Map<String, Integer> getLocalDicionaryMap() {
    	Map<String, Integer> dicionary = new HashMap<String, Integer>();
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File( classLoader.getResource("AFINN-111pt.txt").getFile() );
    	BufferedReader bufferedReader = null;
    	
    	try {
			bufferedReader = new BufferedReader( new FileReader( file ) );
			String currentLine = new String();
			
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] wordAndWeight = currentLine.split(";");
				dicionary.put(wordAndWeight[0], Integer.parseInt(wordAndWeight[1]));
			}
	
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
    	
    	return dicionary;
    }
}
