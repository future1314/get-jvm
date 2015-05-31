/**
 * 被动引用不会触发类的初始化的例子
 */
package getset.classloading;

public class NotInitialized {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 只初始化SuperClass
		System.out.println(SubClass.str1);
		
		// 不会初始化SuperClass，只会初始化一个数组类
		@SuppressWarnings("unused")
		SuperClass[] cs = new SuperClass[10];
		
		// 不会初始化SubClass，该常量编译期间已经到SubClass的常量池中
		System.out.println(SubClass.str2);
	}

}

class SuperClass{
	static{
		System.out.println("SuperClass init...");
	}
	public static String str1 = "hello";
}

class SubClass extends SuperClass{
	static{
		System.out.println("SubClass init...");
	}
	public static final String str2 = "world";
}