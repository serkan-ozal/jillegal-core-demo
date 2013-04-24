/**
 * @author SERKAN OZAL
 *         
 *         E-Mail: <a href="mailto:serkanozal86@hotmail.com">serkanozal86@hotmail.com</a>
 *         GitHub: <a>https://github.com/serkan-ozal</a>
 */

package tr.com.serkanozal.jillegal.demo.core.util;

import java.util.ArrayList;
import java.util.List;

import tr.com.serkanozal.jillegal.core.Jillegal;
import tr.com.serkanozal.jillegal.core.util.JvmUtil;

public class JvmUtilDemo {

	static {
		Jillegal.init();
	}
	
	public static void main(String[] args) throws Exception {
		JvmUtil.info();
		
		///////////////////////////////////////////////////////////////////////////////////////
		SampleClass obj = new SampleClass();
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		long addressOfObj = JvmUtil.addressOf(obj);
		long sizeOfObj = JvmUtil.sizeOf(obj);
		System.out.println("Memory Layout of SampleClass object: ");
		System.out.println("==========================================================");
		JvmUtil.dump(addressOfObj, sizeOfObj);
		System.out.println("==========================================================\n\n");

		///////////////////////////////////////////////////////////////////////////////////////
		
		long addressOfField_b = JvmUtil.addressOfStaticField(SampleClass.class, "b");
		long addressOfClass = JvmUtil.addressOfClass(obj.getClass());
		long sizeToDump =  (addressOfField_b - addressOfClass) + JvmUtil.BYTE_SIZE;
		System.out.println("Memory Layout of SampleClass class: ");
		System.out.println("==========================================================");
		JvmUtil.dump(addressOfClass, sizeToDump);
		System.out.println("==========================================================\n\n");
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Field Layout of SampleClass object: ");
		System.out.println("==========================================================");
		System.out.println(JvmUtil.fieldsLayoutAsString(obj.getClass()));
		System.out.println("==========================================================\n\n");
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		@SuppressWarnings("serial")
		List<SampleClass> list = new ArrayList<SampleClass>() {{
			add(new SampleClass());
			add(new SampleClass());
			add(new SampleClass());
		}};
		
		System.out.println("Dump of sample list with elements typed SampleClass: ");
		System.out.println("==========================================================");
		System.out.println(JvmUtil.dump(list));
		System.out.println("==========================================================\n\n");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////

	public static class SampleClass {
		
		private final static byte b = 100;
		
		private int i = 5;
		private long l = 10;
		
		public int getI() {
			return i;
		}
		
		public void setI(int i) {
			this.i = i;
		}

		public long getL() {
			return l;
		}
		
		public void setL(long l) {
			this.l = l;
		}

		public static byte getB() {
			return b;
		}
		
	}

}
