package RNDP;

public class Amount {
	public static int countWays(int amount,int[] denom){
		if(amount<=0) return 0;
		return count(amount,denom,0);
	}

	public static int count(int amount, int[] denom, int index){
		if(index>=denom.length-1) return 1;
		int d = denom[index];
		int cnt =0;
		for(int i=0;i*d<=amount;++i){
			cnt += count(amount-i*d, denom,index+1);
		}
		return cnt;
	}

	public static void main(String[] args){
		int[] denom = {25,10,5,1};
		int amount = 100;
		System.out.println("Number of ways to count : " + countWays(amount,denom));
	}
}
