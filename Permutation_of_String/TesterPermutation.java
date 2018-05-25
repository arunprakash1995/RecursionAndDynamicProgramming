package RNDP;

public class TesterPermutation {
	public static void main(String[] args){
		String str = "abc";
		String st= "aabc";
		System.out.println("Perm of "+ str + " : "+ Permutation.find(str));
		System.out.println("Perm of "+ str + " : "+ Permutation.findPermutation(str));
		System.out.println("Perm of "+ str + " : "+ Permutation.findDup(st));
	}
}
