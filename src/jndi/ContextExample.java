package jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextExample {

	public static void main(String[] args) throws NamingException {

		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		environment.put(Context.PROVIDER_URL, "file:/D:/");

		Context context = new InitialContext(environment);

		Monkey monkey = new Monkey("My Monkey", "bananas", true);
		context.bind("my monkey", monkey);

		// context.unbind("my monkey");
		// context.bind("my monkey 2", new Monkey("My Monkey 2", "bananas", true));

		// Object object = context.lookup("my monkey 2");
		// System.out.println(object.getClass().getName());
		// System.out.println(object);

		Monkey monkey2 = (Monkey) context.lookup("my monkey");
		System.out.println(monkey2);

	}
}
