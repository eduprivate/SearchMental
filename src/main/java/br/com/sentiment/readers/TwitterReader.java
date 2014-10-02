package br.com.sentiment.readers;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterReader {
	
	public TwitterReader() {
	    super();
	}
	
	public List<String> readTweets(String queryTerm) {
		List<String> documents = new ArrayList<String>();
		Twitter twitter = new TwitterFactory().getInstance();
        
		try {
            Query query = new Query(queryTerm);
            
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	documents.add(tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
           
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
		return documents;
	}	
}
