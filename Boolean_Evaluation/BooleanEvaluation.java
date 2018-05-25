package RNDP;

import java.util.HashMap;
import java.util.Map;

public class BooleanEvaluation {
	
	public static int countWays(String str,boolean res){
		Map<String,Integer> cache = new HashMap<String,Integer>();
		return countWays(str,res,cache);
	}
	
	public static int countWays(String str,boolean res, Map<String,Integer> cache){
		if(str==null)return 0;
		if(str.length()==1) return bool(str.charAt(0))==res?1:0;
		if(cache.containsKey(str)) return cache.get(str);
		int result = 0;	
		for(int i=1;i<str.length();i=i+2){
			String left = str.substring(0,i);
			String right = str.substring(i+1);
			int leftTrue = countWays(left,true);
			int leftFalse = countWays(left,false);
			int rightTrue = countWays(right,true);
			int rightFalse = countWays(right,false);

			int total = (leftTrue+leftFalse)*(rightTrue+rightFalse);

			int totTrue = 0;

			if(str.charAt(i)=='&'){
				totTrue = (leftTrue*rightTrue);
			}
			if(str.charAt(i)=='|'){
				totTrue = (leftTrue*rightTrue) + (leftTrue*rightFalse) +(leftFalse*rightTrue);
			}
			if(str.charAt(i)=='^'){
				totTrue = (leftTrue*rightFalse)+ (leftFalse*rightTrue);
			}
			if(res){
				result+= totTrue;
			}
			else{
				result+=total-totTrue;
			}
		}
		cache.put(str, result);
		return result;
	}

	public static boolean bool(char c) {
		return c=='1'?true:false;
	}

	public static void main(String[] args) {
		String str = "0&0&0&1^1|0";
		boolean b = true;
		System.out.println("No of ways for evaulating "+ str + " as "+b+ " : "+countWays(str,true));
	}
}

