package jndi.dir;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;

public class AttributesLdapExample {

	public static void main(String[] args) throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=jEdu");

		DirContext dirContext = new InitialDirContext(env);

		/* ========================================== */
		// ModificationItem modificationItem = new ModificationItem(DirContext.ADD_ATTRIBUTE, new BasicAttribute(
		// "description", "jEdu"));
		// dirContext.modifyAttributes("cn=Ben Dubin, ou=People", new ModificationItem[] { modificationItem });
		/* ========================================== */

		/* ========================================== */
		// Attributes attributes = new BasicAttributes(true);
		// attributes.put("description", "updated");
		// dirContext.modifyAttributes("cn=Ben Dubin, ou=People", DirContext.REPLACE_ATTRIBUTE, attributes);

		/* ========================================== */
		// DirContext peopleContext = (DirContext) dirContext.lookup("ou=People");
		// Attributes attributes2 = new BasicAttributes(true);
		// attributes2.put("description", "updated2");
		// peopleContext.modifyAttributes("cn=Ben Dubin", DirContext.REPLACE_ATTRIBUTE, attributes2);
		/* ========================================== */

		/* ========================================== */
		dirContext.modifyAttributes("cn=Ben Dubin, ou=People", new ModificationItem[] { new ModificationItem(
				DirContext.REMOVE_ATTRIBUTE, new BasicAttribute("description", null)) });
		/* ========================================== */

	}
}
