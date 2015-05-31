package getset.gc;

import java.util.Map;

public class StackTraceElementTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(Map.Entry<Thread, StackTraceElement[]> stackTrace:
			Thread.getAllStackTraces().entrySet()){
			Thread thread = (Thread)stackTrace.getKey();
			StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
			if(thread.equals(Thread.currentThread())){
				continue;
			}
			System.out.println("\n线程：" + thread.getName() + "\n");
			for(StackTraceElement element:stack){
				System.out.println("\t" + element + "\n");
			}
		}
	}

}
