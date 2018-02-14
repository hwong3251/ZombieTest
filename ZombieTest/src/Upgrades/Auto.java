package Upgrades;

import Characters.Bullet;

public class Auto extends Weapons{
	
	private int dmg = 20;
	private int price;
	private boolean equipped;
	private Bullet bul;
		
	public Auto(int dmg, int price, boolean equipped, Bullet bul) {
		super(dmg, price, equipped, bul);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getPrice() {
		return this.price;
	}

}
