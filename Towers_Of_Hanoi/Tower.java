package RNDP;

import java.util.Stack;

public class Tower{
	Stack<Integer> st = new Stack<Integer>();
	int id;

	Tower(int id){
		st = new Stack<Integer>();
		this.id = id;
	}	

	public boolean add(int disk){
		if(disk>=top()){
			return false;
		}
		else{
			st.push(disk);
			return true;
		}
	}

	public int top(){
		if(st.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return this.st.peek();
	}

	public void moveDisk(Tower buffer, Tower destination,int n){
		if(n<=0) return;
		moveDisk(destination,buffer,n-1);
		moveTop(destination);
		buffer.moveDisk(this,destination,n-1);
	}

	public void moveTop(Tower destination){
		if(this.st.isEmpty()){
			return;
		}
		destination.st.push(this.st.pop());
	}

}

