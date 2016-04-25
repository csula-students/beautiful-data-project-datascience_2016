package homework;

import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTweetApi {

	public static void main (String args[]) throws TwitterException, InterruptedException {
		
		int counter = 0;
		int noofTweets=0;
		while(true){
		
			
			ConfigurationBuilder build = new ConfigurationBuilder(); 
			if(
			build.setDebugEnabled(true)
				.setOAuthConsumerKey("1MNc0guRQjioK2LEFzSgH2yvV")
				.setOAuthConsumerSecret("zPPqY85aKKQDWIGV94pURwuUG5uCRCbj55zTxLDoaqhY9y4CuG")
				.setOAuthAccessToken("162118177-ZHkqkQ8OE5QOOVKw8F0btKXCohwVDNfJDPFiOZnL")
				.setOAuthAccessTokenSecret("hQGyKMIDLFZpw5UueZNhKoEjDcHEz1jKK2HpQ4ao5F34k") != null){
		
			TwitterFactory factory=new TwitterFactory(build.build());
			twitter4j.Twitter tweet = factory.getInstance();
		
			List<Status> status = tweet.getHomeTimeline();
			System.out.println("User -::- Tweet");
		
			for(Status st : status){
			
				System.out.println(st.getUser().getName()+" -::- "+st.getText()+" -::- "+st.getHashtagEntities()+""
						+ " -::- "+st.getGeoLocation()+" -::- "+st.isRetweeted());
				noofTweets++;
			}
			}
			else if(
					build.setDebugEnabled(true)
					.setOAuthConsumerKey("dZHXGePfSlcA0xZ2VRFqruUBr")
					.setOAuthConsumerSecret("xHMDL1NLupgf6Jt3NXlMcHEq9jhfc6uIUMKW2obnzqzXi705oU")
					.setOAuthAccessToken("3275145751-1m9SQWWblQ6zWoIsgqdJH5HWGaZZBrSgsYhA2S3")
					.setOAuthAccessTokenSecret("lMR8ufU7MjESjPgjvHZ4InJXIcPUwVpzHSqNC8cgMjuId") != null){
				
				TwitterFactory factory=new TwitterFactory(build.build());
				twitter4j.Twitter tweet = factory.getInstance();
			
				List<Status> status = tweet.getHomeTimeline();
			
				for(Status st : status){
				
					System.out.println(st.getUser().getName()+" -::- "+st.getText()+" -::- "+st.getHashtagEntities()+""
							+ " -::- "+st.getGeoLocation()+" -::- "+st.isRetweeted());
					noofTweets++;
				}
				
			}
			System.out.println("NO of tweets : "+noofTweets);
			counter++;
			if(counter%140==0){
				Thread.sleep(10);
			}
		
		}	
	}
}
