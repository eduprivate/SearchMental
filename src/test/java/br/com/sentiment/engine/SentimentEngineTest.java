package br.com.sentiment.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.sentiment.dicionary.DicionaryType;
import br.com.sentiment.dicionary.LoadDicionary;
import br.com.sentiment.model.Result;

public class SentimentEngineTest {
	
	@Test
	public void testSentiment() {
		LoadDicionary dicionaryLoader = new LoadDicionary();
		Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
		List<String> documentos = new ArrayList<String>();
		String documento = "A Dilma na presidencia me deixa angustiada. É uma piada";
		documentos.add( documento );
		SentimentEngine engine = new SentimentEngine(documentos, dicionary);
		
		Result result = engine.analyze();
		
		Assert.assertNotNull(result);
		Assert.assertTrue( result.getNegative() < 0 );
		
	}

}
