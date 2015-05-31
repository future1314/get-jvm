package getset.reflection;

import java.lang.reflect.Method;

public class DumpsMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		Class<?> clazz = Class.forName("reflection.InvokeTester");
		
		Object obj = clazz.newInstance();
		
		Method addMethod = clazz.getMethod("add", new Class[]{int.class, int.class});
		Object result = addMethod.invoke(obj, new Object[]{2, 3});
		System.out.println(result);
		
		Method printMethod = clazz.getMethod("print", new Class[]{String.class});
		printMethod.invoke(obj, "world");
	}

}
