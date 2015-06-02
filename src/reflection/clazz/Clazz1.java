package reflection.clazz;

import java.lang.reflect.Field;

public class Clazz1 {

	public static void main(String args[]) throws NoSuchFieldException,
			SecurityException {
		Field f = System.class.getField("out");
		Class c = f.getDeclaringClass();
		System.out.println(c);
	}

}
