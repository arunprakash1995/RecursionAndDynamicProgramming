package RNDP;

import HM.HelperMethods;
import RNDP.MagicIndex;
public class TesterMagicIndex {

	public static void main(String[] args) {
		int size=15;
		int[] array = HelperMethods.randomArray(size, 0, size);
		HelperMethods.printArray(array);
		System.out.println("Magic Index : " + MagicIndex.find(array,false));
	}
}
