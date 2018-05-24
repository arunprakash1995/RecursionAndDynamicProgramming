package RNDP;

import java.util.ArrayList;

public class TesterPowerSet {
	public static void main(String[] args) {
		int size = 4;
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=1;i<=size;++i) {
			l.add(i);
		}
		ArrayList<ArrayList<Integer>> powerset = PowerSet.find(l);
		System.out.println(powerset);
	}
}
