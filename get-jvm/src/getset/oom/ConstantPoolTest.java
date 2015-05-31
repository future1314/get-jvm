package getset.oom;

public class ConstantPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 在jdk6中，字符串放在常量池中
		// intern()方法执行时首先看常量池中是否有该字符串，如果没有就复制该字符串放到常量池中，并返回字符串，如果有则返回代表池中的这个字符串的String对象
//		String str = "javavm";
		@SuppressWarnings("unused")
		String str = new String("javavm");
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("java").append("vm").toString();
		System.out.println(str2.intern() == str2);
	}

}
