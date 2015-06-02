package jndi.dir;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchResult;

public class SearchLdapExample {

	public static void main(String[] args) throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=jEdu");

		DirContext dirContext = new InitialDirContext(env);

		Attributes matchingAttributes = new BasicAttributes();
		matchingAttributes.put("sn", "Dubin");

		NamingEnumeration<SearchResult> searchResults = dirContext.search("ou=People", matchingAttributes);
		print(searchResults);

		String filterExpression = "(&(mail=Ben.Dubin@jEdu.com)(sn=Dubin))";
		searchResults = dirContext.search("ou=People", filterExpression, null);
		print(searchResults);

	}

	private static void print(NamingEnumeration<SearchResult> searchResults) throws NamingException {
		while (searchResults.hasMore()) {
			SearchResult searchResult = searchResults.next();
			System.out.println(searchResult.getName());
			System.out.println(searchResult.getAttributes());
		}
	}
}
