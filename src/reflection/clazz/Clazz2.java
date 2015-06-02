package reflection.clazz;

public class Clazz2 {

	static Object o = new Object() {
		public void m() {
		}
	};

	public static void main(String[] args) {
		Class c = o.getClass().getDeclaringClass();
		System.out.println(c);

	}
}