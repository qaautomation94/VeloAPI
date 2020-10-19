package Videos;

import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;

public class sdaas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			  
		    int length = 10;
		    boolean useLetters = true;
		    boolean useNumbers = true;
		    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		 
		    System.out.println(generatedString);
		    
		    /*
		    String str = "Hey this is Ram";
			String [] words = str.split("is", 2);
	 
			for (String word : words)
				System.out.println(word);
*/

		    String text = "i have a male cat. the color of male cat is Black";
		    int c = 0;
		    for (int j = 0; j < text.length(); j++) {
		        if (text.contains("male cat")) {
		            c += 1;
		        }
		    }

		    System.out.println("counter=" + c);
			
	
	}

		    
}
