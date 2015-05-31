package getset.classloading;

public class LoadClassTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		loader.loadClass("classloading.Just4Test");
		
		System.out.println("-----------------");
		
		Class<?> j = Class.forName("classloading.Just4Test");
		
		Class<?> clazz1 = Class.forName("java.lang.String");
		System.out.println(clazz1.getClassLoader());
		
		System.out.println(j.getClassLoader());
	}

}


class Just4Test{
	static{
		System.out.println("Just4Test init");
	}
}