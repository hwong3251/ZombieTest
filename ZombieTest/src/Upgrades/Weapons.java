package Upgrades;

import Characters.Bullet;

public abstract class Weapons {
	private int dmg;
	private int price;
	private boolean equipped;
	private Bullet bul;
	
	public Weapons(int dmg, int price, boolean equipped, Bullet bul)
	{
		this.dmg = dmg;
		this.price = price;
		this.equipped = equipped;
		this.bul = bul;
	}
	
	public abstract void setDamage(int dmg);
	public abstract int getPrice();
	
}
