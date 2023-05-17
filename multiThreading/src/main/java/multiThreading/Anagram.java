package multiThreading;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String s1="akash shetty";
		String s2="akash ";
		
		char[] charArray1 = s1.toCharArray();
	    char[] charArray2 = s2.toCharArray();
			
	    Arrays.sort(charArray1); Arrays.sort(charArray2);
	    
	    
		if(Arrays.equals(charArray1, charArray2)) {
			System.out.println("anagrams");
		}
		else {
			System.out.println("not anagrams");
		}
		
	}

}
