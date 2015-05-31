/*
 * 测试新生代垃圾收集动作Minor GC：对象优先在Eden分配、
 * VM参数：-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:UseSerialGC
 * 分配allocation4时，Eden空间不足，会触发一次Minor GC，虚拟机同时发现三个2M的对象无法放入Survivor空间中，
 * 因此直接通过分配担保机制提前转移到老年代去了
 */
package getset.gc;

public class TestMinorGC {

	private static final int _1MB = 1024 * 1024;
	
	@SuppressWarnings("unused")
	public static void testAllocation(){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testAllocation();
	}

}
