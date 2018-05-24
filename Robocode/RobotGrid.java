package RNDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import HM.HelperMethods;

public class RobotGrid {
	public static class Point{
		int row;
		int col;
		Point(int r,int c){
			row=r;
			col=c;
		}

		public String toString() {
			return ("("+row+','+col+')');
		}
	}

	public static ArrayList<Point> findPath(boolean[][] mat){
		if(mat==null || mat.length==0)return null;
		int row = mat.length-1;
		int col = mat[0].length-1;
		ArrayList<Point> path= new ArrayList<Point>();
		HashSet<Point> cache = new HashSet<Point>();// points with no path
		if(isPath(mat,row,col,path,cache)) {
			return path;
		}
		return null;
	}

	public static boolean isPath(boolean[][] mat,int r,int c,ArrayList<Point>path,HashSet cache){
		if(r<0 || c<0 || !mat[r][c]) return false;
		Point p = new Point(r,c);
		if(cache.contains(p)){
			return false;
		}
		boolean origin=false;
		if(r==0 && c==0) {
			origin=true;
		}
		if(origin || isPath(mat,r-1,c,path,cache)||isPath(mat,r,c-1,path,cache)){
			path.add(p);
			return true;
		}
		cache.add(p);
		return false;
	}

	public static void main(String[] args) {
		int nRows=5;
		int nCols=7;
		boolean[][] matrix = HelperMethods.randomBooleanMatrix(nRows,nCols,80);
		HelperMethods.printMatrix(matrix);
		ArrayList<Point> path = findPath(matrix);
		if(path!=null) {
			System.out.println("Path : "+ path.toString());
		}
		else {
			System.out.println("Path Not Available");
		}
	}
}

