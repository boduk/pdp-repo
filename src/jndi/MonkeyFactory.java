package jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class MonkeyFactory implements ObjectFactory {

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {

		if (!(obj instanceof Reference)) {
			return null;
		}

		Reference reference = (Reference) obj;
		if (!Monkey.class.getName().equals(reference.getClassName())) {
			return null;
		}

		Monkey monkey = new Monkey();
		Enumeration<RefAddr> addresses = reference.getAll();
		while (addresses.hasMoreElements()) {
			RefAddr refAddr = (RefAddr) addresses.nextElement();
			switch (refAddr.getType()) {
			case Monkey.NAME:
				monkey.setName((String) refAddr.getContent());
				break;
			case Monkey.FAV_FRUIT:
				monkey.setFavFruit((String) refAddr.getContent());
				break;
			case Monkey.LIKES_BANANAS:
				monkey.setLikesBananas(Boolean.valueOf((String) refAddr.getContent()));
				break;
			}
		}
		return monkey;
	}
}
