package RNDP;

import java.util.ArrayList;

public class BoardGame {

	public static ArrayList<Integer[]> placeQueens(int r,int c){
		if(r!=c) return null;
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		Integer[] pos = new Integer[r];
		placeQ(r,c,result,pos,0);
		return result;
	}

	public static void placeQ(int r, int c, ArrayList<Integer[]> result, Integer[] pos, int index){
		if(index==r){
			result.add(pos.clone());
			return;
		}
		for(int j=0;j<c;++j){
			if(checkPos(pos,index,j)){
				pos[index]=j;
				placeQ(r,c,result,pos,index+1);
			}
		}
	}


	public static boolean checkPos(Integer[] pos, int r,int c){
		for(int i=0;i<r;++i){
			if(pos[i]==c){
				return false;
			}
			int colDiff = c-pos[i];
			int rowDiff = r-i;
			if(colDiff==rowDiff){
				return false;
			}
		}
		return true;
	}
	
	public static void printPositions(ArrayList<Integer[]> result) {
		for(Integer[] r:result) {
			System.out.println();
			for(int i=0;i<r.length;++i) {
				System.out.print(r[i]+ " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int r=8;
		int c=8;
		System.out.println("Possible Queen Positions : " );
		ArrayList<Integer[]> result = (placeQueens(r,c));	
		printPositions(result);
	}
}

