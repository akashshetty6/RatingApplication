package multiThreading;

public class Table {

	public static void main(String[] args) {
		
		Method m=new  Method();
		
		Thread t1=new Thread(()->{
			m.getValue(10);
		});
		
		Thread t2=new Thread(()->{
			m.getValue(9);
		});
	
		t1.start();
		t2.start();

}
}

class Method {
//	int n;
	
	public synchronized void getValue(int n) {
		for(int i=1;i<11;i++) {
			System.out.println(n*i);
		}
	}
}