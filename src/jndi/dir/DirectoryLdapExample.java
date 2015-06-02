package jndi.dir;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class DirectoryLdapExample {

	public static void main(String[] args) throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=jEdu");

		DirContext dirContext = new InitialDirContext(env);

		/* ========================================== */
		// NamingEnumeration<Binding> listBindings = dirContext.listBindings("");
		// while (listBindings.hasMoreElements()) {
		// Binding binding = listBindings.nextElement();
		// System.out.println(binding.getName());
		// }
		/* ========================================== */

		/* ========================================== */
		DirContext groupContext = (DirContext) dirContext.lookup("ou=Groups");
		DirContext peopleContext = (DirContext) dirContext.lookup("ou=People");
		NameParser nameParser = peopleContext.getNameParser("");

		NamingEnumeration<Binding> groupsBindings = groupContext.listBindings("");
		while (groupsBindings.hasMore()) {
			Binding binding = groupsBindings.next();
			String bindingName = binding.getName();
			Attributes groupAttributes = groupContext.getAttributes(bindingName);
			Attribute groupMembers = groupAttributes.get("uniquemember");
			Attribute groupName = groupAttributes.get("cn");
			System.out.println(groupName.get());

			NamingEnumeration<?> allMembers = groupMembers.getAll();
			while (allMembers.hasMore()) {
				String memberDN = allMembers.next().toString();
				// System.out.println("			" + memberDN);
				Name memberName = nameParser.parse(memberDN);
				// System.out.println(memberName.get(2));
				DirContext memberContext = (DirContext) peopleContext.lookup(memberName.get(2));
				Attributes memberAttributes = memberContext.getAttributes("", new String[] { "cn", "mail" });
				System.out.println("	" + memberAttributes.get("cn").get() + " - " + memberAttributes.get("mail").get());
			}

		}
		/* ========================================== */
	}

}
