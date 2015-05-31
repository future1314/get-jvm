/*
 * Java堆内存发生OutOfMemoryError错误的测试
 * 测试方法：不断创建对象
 * VM参数：-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
package getset.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	
	static class OOMObject{
		@SuppressWarnings("unused")
		private static final byte[] a = new byte[1024*1024];
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		List<OOMObject> list = new ArrayList<OOMObject>();
		System.getProperty("com.boot.class.path");
		int count = 1;
		while(true){
			list.add(new OOMObject());
			Thread.sleep(50);
			System.out.println(count++);
		}
	}

}
