package Videos;

class example
{
	public static void main(String args[])
	{
		String str = "Response Body is{\"Videos\":[{\"ID\":40797343,\"Name\":\"AutoVideo892\",\"Type\":\"PRODUCT\",\"URL\":\"https://www.youtube.com/watch?v=EY41X9sfxlA892\",\"Description\":\"\"},{\"ID\":40799674,\"Name\":\"AutoVideo7932\",\"Type\":\"PRODUCT\",\"URL\":\"https://www.youtube.com/watch?v=EY41X9sfxlA7932\",\"Description\":\"\"},{\"ID\":40846298,\"Name\":\"abc\",\"Type\":\"PRODUCT\",\"URL\":\"https://www.youtube.com/watch?v=cqyziA30whE\",\"Description\":\"\"},{\"ID\":40928539,\"Name\":\"AutoVideo2774\",\"Type\":\"PRODUCT\",\"URL\":\"https://www.youtube.com/watch?v=EY41X9sfxlA2774\",\"Description\":\"\"}],\"TotalCount\":4}\r\n" + 
				"";
		String [] words = str.split("\"ID\":");
		int a=words.length;
		System.out.println(a);
		for(a=1; a<5; a++) {
			String abc=words[a];
			int i = abc.indexOf(',');
			String wordfirst = abc.substring(0, i);
			System.out.println(wordfirst);

		}
		
	
		
		for (String word : words)
			System.out.println(word);
	}
}