package multiThreading;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		System.out.println("akash");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
