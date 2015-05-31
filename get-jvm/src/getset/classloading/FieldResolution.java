package getset.classloading;

public class FieldResolution {

	interface Interface0{
		int a = 0;
	}
	interface Interface1 extends Interface0{
		int a = 1;
	}
	interface Interface2{
		int a = 2;
	}
	static class Parent implements Interface1{
		public static int a = 3;
	}
	static class Sub extends Parent implements Interface2{
		// 注释该句之后将报错
		public static int a = 4;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Sub.a);
	}

}
