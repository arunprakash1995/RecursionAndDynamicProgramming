package RNDP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StackBox {
	public static class Box implements Comparator<Box>{
		int h;
		int w;
		int l ;
		Box(int h,int w,int l){
			this.h=h;
			this.w=w;
			this.l=l;
		}
		
		Box(){
			h=0;
			w=0;
			l=0;
		}
		
		public String toString() {
			return "["+h+" "+w+" "+l+"]";
		}
		
		@Override
		public int compare(Box a,Box b){
			return b.h-a.h;
		}
	}

	public static int createStacks(ArrayList<Box> l){
		if(l==null)return 0;
		Collections.sort(l,new Box());
		System.out.println(l);
		int height=0;
		int[] cache = new int[l.size()+1];
		Arrays.fill(cache, -1);
		for(int index=0;index<l.size();++index) {
			height = Math.max(height, createStack(l,index,cache));
		}
		return height;
	}

	public static int createStack(ArrayList<Box> l, int index,int[] cache){
		if(index>=l.size()) return 0;
		if(cache[index]>0) return cache[index];
		Box b = l.get(index);
		int height = 0;
		for(int i=index+1;i<l.size();++i){
			if(canBeAbove(b,l.get(i))){
				int h= createStack(l,i,cache);
				height = Math.max(h,height);
			}
		}
		cache[index]= (height+= b.h);
		return height;
	}

	public static boolean canBeAbove(Box a,Box b){
		if(a.l<b.l || a.h<b.h || a.w<b.w) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStacks(boxes);
		System.out.println(height);
	}
}

