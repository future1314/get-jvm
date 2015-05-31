package getset.classloading;

public class DeadLoopClass {

	static{
		if(true){
			System.out.println(Thread.currentThread() + "init DeadLoopClass");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				@SuppressWarnings("unused")
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		
		System.out.println(t1.getClass().getClassLoader());
	}

}
