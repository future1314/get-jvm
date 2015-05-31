/*
 * 测试Java虚拟机栈OutOfMemoryError错误
 * 通过创建多线程的方式达到，会造成死机
 * VM参数：-XX:PermSize=10m -XX:MaxPermSize=10m
 */
package getset.oom;

public class JavaVMStackOOM {

	private void dontstop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run() {
					dontstop();
				}
			});
			thread.start();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 容易宕机
//		JavaVMStackOOM test = new JavaVMStackOOM();
//		test.stackLeakByThread();
		
	}

}
