package getset.reflection;

public class DynamicClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ISubject subject = new SubjectImpl();
		SubjectProxy proxy = new SubjectProxy();
		ISubject proxyInstance = (ISubject)proxy.bind(subject);
		
		proxyInstance.doSomething("work");
	}

}
