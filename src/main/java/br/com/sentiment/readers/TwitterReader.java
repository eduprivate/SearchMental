package br.com.sentiment.readers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterReader {
	
	Logger logger = Logger.getLogger(TwitterReader.class);
	
	public TwitterReader() {
	    super();
	}
	
	public List<String> readTweets(String queryTerm) {
		logger.info("Starting reading tweets: ");
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
        	logger.error("Error during reading twitter.", te);
        }
		return documents;
	}	
}
