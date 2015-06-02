package reflection.clazz;

public class Clazz {

	static Object o = new Object() {
		public void m() {
		}
	};

	public static void main(String[] args) {
		Class c = o.getClass().getEnclosingClass();
		System.out.println(c);

	}
}