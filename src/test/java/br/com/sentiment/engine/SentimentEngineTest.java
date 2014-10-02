package br.com.sentiment.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.sentiment.dicionary.DicionaryType;
import br.com.sentiment.dicionary.LoadDicionary;
import br.com.sentiment.model.AnalizeResult;

public class SentimentEngineTest {
	
	@Test
	public void testSentiment() {
		LoadDicionary dicionaryLoader = new LoadDicionary();
		Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
		List<String> documentos = new ArrayList<String>();
		String documento = "A Dilma na presidencia me deixa angustiado. É uma piada. Já foi boa.";
		documentos.add( documento );
		SentimentEngine engine = new SentimentEngine(documentos, dicionary);
		
		AnalizeResult result = engine.analyze();
		
		System.out.println( "Negativo: "+ result.getNegative() );
		System.out.println( "Positivo: "+ result.getPositive() );
		
		Assert.assertNotNull(result);
		Assert.assertTrue( result.getNegative() < 0 );
		
	}

}
