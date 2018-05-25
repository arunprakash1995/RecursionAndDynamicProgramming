package RNDP;

import java.util.ArrayList;
import java.util.HashSet;

public class Parentheses {

	public static HashSet<String> findCombination(int n){
		if(n<0) return null;
		return find(n);
	}

	public static HashSet<String> find(int n){
		HashSet<String> set = new HashSet<String>();
		if(n==0){
			set.add("");
			return set;
		}
		HashSet<String> prevSet = find(n-1);
		for(String s:prevSet){
			for(int i=0;i<s.length();++i){
				if(s.charAt(i)=='('){
					String str= insertParenAt(i+1,s);
					set.add(str);
				}
			}
			String str = "()"+s;
			set.add(str);
		}
		return set;
	}

	public static String insertParenAt(int index,String s){
		String before = s.substring(0,index);
		String after = s.substring(index);
		return before+"()"+after;
	}
	
	public static ArrayList<String> findCombParen(int n){
		if(n<=0) return null;
		ArrayList<String> result = new ArrayList<String>();
		findParen(n,n,"",result);
		return result;
	}

	public static void findParen(int lRem,int rRem,String prefix, ArrayList<String> result ) {
		if(lRem==0 && rRem==0) {
			result.add(prefix);
		}
		if(lRem>rRem || lRem<0) {
			return;
		}	
		findParen(lRem-1,rRem,prefix+"(",result);
		findParen(lRem,rRem-1,prefix+")",result);
	}
	
	public static void main(String[] args){
		int n=3;
		System.out.println("Combination of paren for n = "+ n + " : " + findCombination(n));
		System.out.println("Combination of paren for n = "+ n + " : " + findCombParen(n));
	}
}
