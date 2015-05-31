package getset.reflection;

public class SubjectImpl implements ISubject {

	/* (non-Javadoc)
	 * @see reflection.ISubject#doSomething(java.lang.String)
	 */
	@Override
	public void doSomething(String str) {
		System.out.println("do: " + str);
	}
}
