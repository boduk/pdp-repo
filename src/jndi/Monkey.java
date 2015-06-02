package jndi;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class Monkey implements Referenceable {

	public static final String NAME = "name";
	public static final String FAV_FRUIT = "favourite fruit";
	public static final String LIKES_BANANAS = "likes bananas";

	private String name;
	private String favFruit;
	private Boolean likesBananas;

	public Monkey() {
	}

	public Monkey(String name, String favFruite, Boolean likesBananas) {
		this.name = name;
		this.favFruit = favFruite;
		this.likesBananas = likesBananas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavFruit() {
		return favFruit;
	}

	public void setFavFruit(String favFruit) {
		this.favFruit = favFruit;
	}

	public Boolean getLikesBananas() {
		return likesBananas;
	}

	public void setLikesBananas(Boolean likesBananas) {
		this.likesBananas = likesBananas;
	}

	@Override
	public Reference getReference() throws NamingException {
		Reference reference = new Reference(this.getClass().getName(), MonkeyFactory.class.getName(), null);

		reference.add(new StringRefAddr(NAME, this.name));
		reference.add(new StringRefAddr(FAV_FRUIT, this.favFruit));
		reference.add(new StringRefAddr(LIKES_BANANAS, this.likesBananas.toString()));

		return reference;
	}

	@Override
	public String toString() {
		return "Monkey [name=" + name + ", favFruit=" + favFruit + ", likesBananas=" + likesBananas + "]";
	}

}
