package getset.classloading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	private String name;
	private String path;
	
	public MyClassLoader(String name){
		super();	// 系统类加载器
		this.name = name;
	}
	
	public MyClassLoader(ClassLoader parent, String name){
		super(parent);	// 指定父类加载器
		this.name = name;
	}
	
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		
		byte[] data = loadClassFile(name);
		return super.defineClass(name, data, 0, data.length);
	}
	
	public byte[] loadClassFile(String className){
		
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		className = className.replace(".", "\\") + ".class";
		
		try{
			is = new FileInputStream(new File(path + className));
			int b;
			
			while(-1 != (b = is.read())){
				baos.write(b);
			}

			is.close();
			baos.close();
		} catch(Exception e){
			e.printStackTrace();
		} 
		
		return baos.toByteArray();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws Exception {
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("E:\\Workspaces\\MyEclipse_10_6\\jvmtest\\myClassLoaderTest\\loader1\\");
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
		loader2.setPath("E:\\Workspaces\\MyEclipse_10_6\\jvmtest\\myClassLoaderTest\\loader2\\");
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
		loader3.setPath("E:\\Workspaces\\MyEclipse_10_6\\jvmtest\\myClassLoaderTest\\loader3\\");

		Object obj1 = test(loader2);
		Object obj2 = test(loader2);
		Object obj3 = test(loader3);
		System.out.println(obj1.getClass() == obj2.getClass());
		System.out.println(obj2.getClass() == obj3.getClass());
		
		Sample1 sample1 = (Sample1)obj1;
		System.out.println(sample1.a);
	}
	
	public static Object test(ClassLoader loader) throws Exception{
		Class<?> clazz = loader.loadClass("Sample1");
		return clazz.newInstance();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
