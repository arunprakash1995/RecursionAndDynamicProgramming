package RNDP;

import java.util.Arrays;

public class ClimbingStairs {
	public static int countWays(int n){
		int[] cache = new int[n+1];
		Arrays.fill(cache,-1);
		return countWays(cache,n);

	}

	public static int countWays(int[] cache,int n){
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(cache[n]>0){
			return cache[n];
		}
		return cache[n]=countWays(cache,n-1)+countWays(cache,n-2)+countWays(cache,n-3);
	}

	public static void main(String[] args){
		int n=5;
		System.out.println("Number of ways to climb stairs of " + n +" steps : " + countWays(n));
	}
}
