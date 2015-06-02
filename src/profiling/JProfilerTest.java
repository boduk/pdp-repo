package profiling;

import java.util.HashMap;
import java.util.Map;

public class JProfilerTest {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Started...");

		Map<String, TestObject> leakMap = new HashMap<String, TestObject>();

		int i = 0;

		while (true) {

			String key = "key_" + i++;

			TestObject object = new TestObject();

			leakMap.put(key, object);

			key = null;

			Thread.sleep(20);

		}

	}

}
