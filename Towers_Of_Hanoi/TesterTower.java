package RNDP;

public class TesterTower {
	public static void main(String[] args){
		int n=3;
		Tower[] t=new Tower[n];
		for(int i=0;i<n;++i){
			t[i] = new Tower(i);
		}

		for(int disk=3;disk>=1;--disk){
			t[0].add(disk);
		}

		System.out.println("Tower 1 : "+ t[0].st);
		System.out.println("Tower 3 : "+ t[2].st);
		t[0].moveDisk(t[1],t[2],2);
		System.out.println("Tower 1 : "+ t[0].st);
		System.out.println("Tower 3 : "+ t[2].st);

	}
}
