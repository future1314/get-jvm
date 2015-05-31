/*
 * 测试垃圾回收前的finalize方法执行
 * 回收前进行两次标记，若第一次标记后执行finalize方法并被引用可以避免被回收
 * 但是finalize方法最多被执行一遍
 */
package getset.gc;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("I am still alive!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed...");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("No, I am dead!");
		}
		System.out.println("again");
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("No, I am dead!");
		}
		
	}

}
