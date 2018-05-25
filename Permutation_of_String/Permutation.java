package RNDP;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutation {
	
	/* Function to print the permutaion of String without duplicates
	 * 
	 * */
	
	public static ArrayList<String> find(String str){
		if(str.length()==0) return null;
		ArrayList<String> result = new ArrayList<String>();
		findPerm("",str,result);
		return result;
	}

	public static void findPerm(String prefix, String str, ArrayList<String> result){
		if(str.length()==0) {
			result.add(prefix);
			return;
		}
		int len = str.length();
		for(int i=0;i<len;++i){
			char c = str.charAt(i);
			String before = str.substring(0,i);
			String after = str.substring(i+1);
			findPerm(prefix+c, before+after, result);
		}
	}
	
	/* Function to print the permutaion of String with duplicates 
	 * 
	 * */
	
	public static ArrayList<String> findDup(String str){
		if(str.length()==0) return null;
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
		buildCharFreq(mp,str);
		findPermDup(mp,"",result,str.length());
		return result;
	}

	public static void buildCharFreq(HashMap<Character,Integer> mp, String str){
		int count = 0;
		for(int i=0;i<str.length();++i){
			count = mp.getOrDefault(str.charAt(i),0);
			count = count+1;
			mp.put(str.charAt(i),count);
		}
	}

	public static void findPermDup(HashMap<Character,Integer> mp, String prefix, ArrayList<String> result,int rem){
		if(rem==0) {
			result.add(prefix);
			return;
		}
		
		for(Character c:mp.keySet()){
			int count = mp.get(c);
			if(count>0) {
				mp.put(c,count-1);
				findPermDup(mp,prefix+c,result,rem-1);
				mp.put(c,count);
			}
		}

	}

	public static ArrayList<String> findPermutation(String str){
		ArrayList<String> result = new ArrayList<String>();
		if(str.length()==0){
			result.add("");
			return result;
		}

		char c = str.charAt(0);
		String s= str.substring(1);
		ArrayList<String> prevResult = findPermutation(s);
		for(String S:prevResult){
			for(int i=0;i<=S.length();++i){
				String nstr = insertAt(S,i,c);
				result.add(nstr);
			}
		}
		return result;
	}

	public static String insertAt(String s,int index,char c){
		String before = s.substring(0,index);
		String after = s.substring(index);
		return before+c+after;

	}
}
