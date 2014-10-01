package br.com.sentiment.engine;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.sentiment.dicionary.DicionaryType;
import br.com.sentiment.dicionary.LoadDicionary;

public class LoadDicionaryTest {
    
	@Test
	public void testLoadLocalDicionary() {
	     LoadDicionary dicionaryLoader = new LoadDicionary();
	     Map<String, Integer> dicionary = dicionaryLoader.getDicionaryMap(DicionaryType.LOCAL);	     
	     Assert.assertTrue( dicionary.size() > 0 );
	}
	
}
