package br.com.sentiment.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.sentiment.dicionary.DicionaryType;
import br.com.sentiment.dicionary.LoadDicionary;
import br.com.sentiment.model.AnalizeResult;
import br.com.sentiment.model.StatisticAnalizeResult;

public class SentimentEngineTest {
	
	@Test
	public void testSentiment() {
		LoadDicionary dicionaryLoader = new LoadDicionary();
		Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
		List<String> documentos = new ArrayList<String>();
		String documento = "A Dilma na presidencia me deixa angustiado. É uma piada. Já foi boa.";
		documentos.add( documento );
		SentimentEngine engine = new SentimentEngine("dilma", documentos, dicionary);
		
		AnalizeResult result = engine.analyze();
		
		System.out.println( "Negativo: "+ result.getNegative() );
		System.out.println( "Positivo: "+ result.getPositive() );
		
		Assert.assertNotNull(result);
		Assert.assertTrue( result.getNegative() < 0 );
		
	}
	
	@Test
	public void testStatisticSentiment() {
		LoadDicionary dicionaryLoader = new LoadDicionary();
		Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);
		List<String> documentos = new ArrayList<String>();
		String documento = "A Dilma na presidencia me deixa angustiado. É uma piada. Já foi boa.";
		String documento2 = "A Dilma é uma excelente presidente. Ela foi ótima.";
		documentos.add( documento );
		documentos.add( documento2 );
		
		SentimentEngine engine = new SentimentEngine("dilma", documentos, dicionary);
		
		StatisticAnalizeResult result = engine.statisticAnalyze();
			
		System.out.println( "Negativo: "+ result.getNegative() );
		System.out.println( "Positivo: "+ result.getPositive() );
		System.out.println( "Count: "+ result.getCount() );
		System.out.println( "Positivo Count: "+ result.getCountPositive() );
		System.out.println( "Negativo Count: "+ result.getCountNegative() );
		System.out.println( "getNegativePercent: "+ result.getNegativePercent());
		System.out.println( "getPositivePercent: "+ result.getPositivePercent());
		
		Assert.assertNotNull(result);
		Assert.assertTrue( result.getNegative() < 0 );
		
	}

}
