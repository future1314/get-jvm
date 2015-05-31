package getset.classloading;


public class Sample1 {

	public int a = 11;
	
	public Sample1() {
		System.out.println("Sample1 is loaded by: " + this.getClass().getClassLoader());
		new Sample2();
	}
}

class Sample2 {
	public Sample2() {
		System.out.println("Sample2 is loaded by: " + this.getClass().getClassLoader());
	}
}
