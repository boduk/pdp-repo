package reflection.clazz;

import java.lang.reflect.Field;

public class Clazz3 {

	class MyString extends java.lang.ClassLoader {
		private Integer private1;
		public Integer public1;
	}

	public static void main(String[] args) {
		Class c = String.class;
		for (Field f : c.getFields()) {
			System.out.println(f.getName());
		}
		System.out.println("===============");
		for (Field f : c.getDeclaredFields()) {
			System.out.println(f.getName());
		}

	}
}