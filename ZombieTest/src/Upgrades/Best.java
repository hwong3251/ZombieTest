package Upgrades;

import Characters.Bullet;

public class Best extends Weapons{
	
	private int dmg = 1000;
	private int price = 999;
	private boolean equipped = false;
	
	public Best(int dmg, int price, boolean equipped, Bullet bul) {
		super(dmg, price, equipped, bul);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setDamage(int d) {
		this.dmg = d;
		
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	public void changeEquipped()
	{
		if(this.equipped==false)
		{
			this.equipped=true;
		}
		else
		{
			this.equipped=false;
		}
	}
}
