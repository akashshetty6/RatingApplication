package multiThreading;

public class myThread implements Runnable{
	public static void main(String[] args) throws Exception {
		Thread t=new Thread(new myThread());
		
		MyThread1 t1=new MyThread1();
		
		t.start();
		t1.start();
		t.join();
			
		
	}

	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
}


