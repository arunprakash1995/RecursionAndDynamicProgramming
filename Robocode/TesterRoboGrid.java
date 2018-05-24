package RNDP;

import java.util.ArrayList;

import HM.HelperMethods;
import RNDP.RobotGrid.Point;

public class TesterRoboGrid {
	public static void main(String[] args) {
		int nRows=5;
		int nCols=7;
		boolean[][] matrix = HelperMethods.randomBooleanMatrix(nRows,nCols,65);
		ArrayList<Point> path = RobotGrid.findPath(matrix);
		HelperMethods.printMatrix(matrix);
		if(path!=null) {
			System.out.println("Path : "+ path.toString());
		}
		else {
			System.out.println("Path Not Available");
		}
	}
}
