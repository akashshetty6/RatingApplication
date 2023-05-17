package multiThreading;

public class Prime {

	public static void main(String[] args) {
		int n=5;
		boolean flag=false;
		int i=2;
		while(i<=(n/2)) {
			if (n%i==0) {
//				System.out.println("prime num");
				flag=true;
				break;
			}
			++i;
		}
		
		if(flag) {
			System.out.println("not a prime");
		}
		else {
		System.out.println(" prime ");
		}

	}

}
