package RNDP;

import java.util.Random;

public class PaintFill {
	enum color {Black, Red, Yellow, Green, Orange, Blue};

	public static boolean fill(color[][] mat, color oldC, color newC, int r, int c){
		if(mat==null) return false;
		if(mat[r][c] == newC) return false; 
		return paint(mat,oldC,newC,r,c);
	}

	public static boolean paint(color[][] mat,color oldC, color newC,int r, int c){
		if(r<0 || c<0 || r>=mat.length || c>=mat[0].length){
			return false;
		}
		if(mat[r][c] == oldC) {
		mat[r][c] = newC;
		paint(mat,oldC,newC,r-1,c);
		paint(mat,oldC,newC,r+1,c);
		paint(mat,oldC,newC,r,c+1);
		paint(mat,oldC,newC,r,c-1);
		}
		return true;
	}
	public static void printMat(color[][] mat) {
		System.out.println();
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				System.out.print((mat[r][c]) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int r=5;
		int c =5;
		color[][] mat = new color[r][c];
		for(int i=0;i<r;++i) {
			for(int j=0;j<c;++j) {
				mat[i][j] = color.Green;
			}
		}
		Random R= new Random();
		for(int i=0;i<30;++i) {
			mat[R.nextInt(r)][R.nextInt(r)] = color.Black;
		}
		printMat(mat);
		paint(mat,color.Black,color.Yellow,3,2);
		printMat(mat);
	}
}
