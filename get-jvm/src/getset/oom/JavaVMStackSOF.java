/*
 * 测试Java虚拟机栈StackOverflowError错误
 * 通过递归调用产生许多本地变量达到
 * VM参数：-Xss128k
 */
package getset.oom;

public class JavaVMStackSOF {

	private int stackLength = 1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF test = new JavaVMStackSOF();
		try{
			test.stackLeak();
		}catch(Throwable e){
			e.printStackTrace();
			System.out.println(test.stackLength);
		}
		
		
	}

}
