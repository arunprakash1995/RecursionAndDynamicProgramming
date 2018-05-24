package RNDP;

public class RecursiveMultiply {
	public static int mul(int a, int b){
		if(a==0 || b==0) return 0;
		int big = a>b?a:b;
		int small = a<b?a:b;
		return findMul(big,small);
	}

	public static int findMul(int b,int s){
		if(b==0 || s==0){
			return 0;
		}
		if(s==1){
			return b;
		}
		int c= s>>1;
		int halfProd = findMul(b,c);
		if(s%2==0){
			return halfProd+halfProd;
		}
		return halfProd+halfProd+b;
	}
	public static void main(String[] args) {
		int a=353;
		int b=212;
		System.out.println(a+" * "+b + " = " + mul(a,b));
	}
}

