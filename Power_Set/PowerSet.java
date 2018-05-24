package RNDP;

import java.util.ArrayList;
import java.util.Arrays;

import HM.HelperMethods;

public class PowerSet {
	public static ArrayList<ArrayList<Integer>> find(ArrayList<Integer> set){
		if(set==null) return null;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		find(set,result,set.size()-1);
		return result;
	}

	public static void find(ArrayList<Integer> set,ArrayList<ArrayList<Integer>> result,int index){
		if(index<0){
			result.add(new ArrayList<Integer>());
			return;
		}
		find(set,result,index-1);
		int val = set.get(index);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> s:result){
			ArrayList<Integer> sub = (ArrayList<Integer>) s.clone();
			sub.add(val);
			subsets.add(sub);
		}
		result.addAll(subsets);
	}
}

