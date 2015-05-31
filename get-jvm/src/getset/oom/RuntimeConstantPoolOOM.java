/*
 * 测试方法区OutOfMemoryError
 * 通过创建String常量达到
 * VM参数：-XX:PermSize=10m -XX:MaxPermSize=10m
 */
package getset.oom;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("RuntimeConstantPoolOOM");

		List<String> list = new ArrayList<String>();
		int value = 1;
		try{
			while(true){
				list.add(String.valueOf("RuntimeConstantPoolOOM" + value++).intern());
				System.out.println(value);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
