package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
import org.json.simple.parser.JSONParser;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.util.*;

public class TwitterApp {

	ArrayList<Tweet> tweetsList;
	
	public TwitterApp(){
		tweetsList = new ArrayList<Tweet>();
	}
	//String filename="C:\\Users\\vallabh\\Desktop\\Twitter_Analysis\\Tweets.txt";
	String filename="C:\\Users\\vallabh\\Desktop\\finaltweet.txt";
	
	public void InsertData(Tweet tweet){

		MongoClient mongo = new MongoClient("localhost", 27017);
		@SuppressWarnings("unused")
		DB db = mongo.getDB("twitterDB");

		//model data add
		DBObject doc = createDBObject(mdata);
		DBCollection col = db.getCollection("tweets");
		
		//
		BasicDBObject doc = new BasicDBObject("text", tweet.getText()).
				append("hashtags",tweet.getHashtags()).
	            append("geo", tweet.getGeo()).
	            append("is_quote_status", tweet.getIs_quote_status()).
	            append("userID", tweet.getUser().getId()).
	            append("user_Follwers_Count", tweet.getUser().getFollowers_count()).
	            append("user_Friends_count",tweet.getUser().getFriends_count()).
	            append("user_location", tweet.getUser().getLocation()).
	            append("user_following",tweet.getUser().getFollowing()).
	            append("user_Geo_enabled",tweet.getUser().getGeo_enabled()).
	            append("user_name",tweet.getUser().getName()).
	            append("user_lamguage",tweet.getUser().getLanguage()).
	            append("user_favorites_count",tweet.getUser().getFavorites_count()).
	            append("user_screen_name",tweet.getUser().getScreen_name()).
	            append("User_Created_at",tweet.getUser().getCreated_at()).
	            append("user_timezone",tweet.getUser().getTimezone());
						
        col.insert(doc);
        System.out.println("Document inserted successfully");
		//
		WriteResult result = col.insert(doc);
		System.out.println("this is data"+result.getUpsertedId());
		System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.unacknowledged());
		
		//read        
		mongo.close();
		
	}
	
	public void Run(){
		
		JSONParser parser = new JSONParser();
		
		try {
			 
            Object obj = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject) obj;
            String text = (String) jsonObject.get("text");
 
            //can be null
            String is_quote_status = (String) jsonObject.get("is_quote_status");
            String geo = (String) jsonObject.get("geo");
            String[] hashtags=(String[]) jsonObject.get("hashtags");
            if(is_quote_status.equals(null) || geo.equals(null)|| hashtags.equals(null)){
            	continue;
            }
            else{
            	
                JSONObject userJson = (JSONObject) jsonObject.get("user");
                
                User user = new User();
                user.setId(userJson.get("id").toString());
                user.setName(userJson.get("name").toString());
                user.setLanguage(userJson.get("language").toString());
                user.setScreen_name(userJson.get("screen_name").toString());
                user.setCreated_at(userJson.get("created_at").toString());
                user.setTime_zone(userJson.get("time_zone").toString());
                int followers_count = Integer.parseInt(userJson.get("followers_count").toString());
        		int friends_count =  Integer.parseInt(userJson.get("friends_count").toString());
                Boolean geo_enabled = Boolean.parseBoolean(userJson.get("geo_enabled").toString());
        		Boolean following = Boolean.parseBoolean(userJson.get("following").toString());
        		int favourite_count = Integer.parseInt(userJson.get("favourites_count").toString());
                user.setFollowers_count(followers_count);
                user.setFriends_count(friends_count);
                user.setGeo_enabled(geo_enabled);
                user.setFollowing(following);
                user.setFavourites_count(favourite_count);

                //can be null
                String location =userJson.get("location").toString(); 

				
            	if(location.equals(null)){
            		continue;
            	}
            	else{
            		user.setLocation(location);

            		//if all the conditions are satisfied then and only then insert the data
            		Tweet tweet = new Tweet();
                    tweet.setText(text);
                    tweet.setIs_quote_status(is_quote_status);
                    tweet.setGeo(geo);
                    tweet.setUser(user);
                    tweet.setHashtags(hashtags);
                    tweetsList.add(tweet);
                    InsertData(tweet);
            	}
            }     
            
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public static void main(String[] args){
		
		TwitterApp app=new TwitterApp();
		app.Run();
		
	}
}
