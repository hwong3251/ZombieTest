package Characters;

public abstract class Character {
	private int hp,dmg;
	private double x,y;
	
	
	public Character(double x, double y, int hp, int dmg)
	{
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.dmg = dmg;
	}
	
	public int getHP()
	{
		return this.hp;
	}
	public int getDMG()
	{
		return this.dmg;
	}
	
}
