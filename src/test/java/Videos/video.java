package Videos;

import org.apache.commons.lang3.RandomStringUtils;

public class video {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		
		
	    
		 	int count = 50;
	        String API_KEY = "AIzaSyCBDqlf23kZZ_4RzSsvLFNkYdo_KLxo9bc";
	        int length = 3;
		    boolean useLetters = true;
		    boolean useNumbers = true;
		    String q = RandomStringUtils.random(length, useLetters, useNumbers);
	        String url = "https://www.googleapis.com/youtube/v3/search?key=" + API_KEY + "&maxResults="+count+"&part=snippet&type=video&q=" +q;
			System.out.println(url);

	}

}
