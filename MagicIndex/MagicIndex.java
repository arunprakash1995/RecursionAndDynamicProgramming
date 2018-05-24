package RNDP;

public class MagicIndex {
		
		/*Function to find Magic index in a array of distinct elements*/
		public static int find(int[] array, boolean distinct){
			if(array==null) return-1;
			if(distinct){
				return findDistinct(array,0,array.length);
			}
			return findNDistinct(array,0,array.length);
		}
		
		public static int findDistinct(int[] array,int l,int h){
			if(h<=l)return -1;
			int mid =(l+h)/2;
			if(array[mid]==mid){
				return mid;
			}
			else if(array[mid]>mid){
				return findDistinct(array,l,mid-1);
			}
			else{
				return findDistinct(array,mid+1,h);
			}
		}

		public static int findNDistinct(int[] array,int l,int h){
			if(h<=l)return -1;
			int mid =(l+h)/2;
			if(array[mid]==mid){
				return mid;
			}
			int leftMax = Math.min(mid-1,array[mid]);
			int rightMin = Math.max(mid+1,array[mid]);
			int left = findNDistinct(array,l,leftMax) ;
			int right = findNDistinct(array,rightMin,h) ;
			
			if(left !=-1){
				return left;
			}
			return right;
		}
	}

