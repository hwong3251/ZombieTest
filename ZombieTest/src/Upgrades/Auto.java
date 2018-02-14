package Upgrades;

import Characters.Bullet;

public class Auto extends Weapons{
	
	private int dmg = 200;
	private int price = 100;
	private boolean equipped = false;
	
	public Auto(int dmg, int price, boolean equipped, Bullet bul) {
		super(dmg, price, equipped, bul);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setDamage(int dmg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
