package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import com.google.common.collect.Lists;

import edu.csula.datascience.acquisition.SimpleModel;

public class Testing {

	 public String readTweet(String filename) throws IOException{
	    	String content = "";
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	try {
	    	    StringBuilder sb = new StringBuilder();
	    	    String line = br.readLine();

	    	    while (line != null) {
	    	        sb.append(line);
	    	        sb.append(System.lineSeparator());
	    	        line = br.readLine();
	    	    }
	    	    content = sb.toString();
	    	} finally {
	    	    br.close();
	    	}
	    	return content;
	    }
	 
	 
	@Test
	public void Test_Mock() throws Exception {
	
    	String content1="", content2="";
		try {
			//reading mock data
			content1 = readTweet("C:\\Users\\vallabh\\Desktop\\bigdata\\homework\\test\\tweet1.txt");
			content2 = readTweet("C:\\Users\vallabh\\Desktop\\bigdata\\homework\\test\\tweet2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(content1, null);
		Assert.assertEquals(content2, null);
		
		Assert.assertEquals(content1, tweet1);
		Assert.assertEquals(content2, tweet2);

	}
	
}
