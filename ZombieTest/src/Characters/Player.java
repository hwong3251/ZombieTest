package Characters;

public class Player extends Character{
	
	private int hp, lvl, gold, dmg;
	private double x,y;
	
	public Player(int hp, double x, double y, int lvl, int gold, int dmg)
	{
		super(x, y, hp, dmg);
		this.lvl = lvl;
		this.gold = gold;
	}
	
	public int takeDamage(int num)
	{
		return hp - num;
	}
	public void nextLvl()
	{
		lvl += 1;
	}
	public int increaseGold(int num)
	{
		return gold += num;
	}
	
	//Getter
	@Override
	public int getHP() 
	{
		// TODO Auto-generated method stub
		return this.hp;
	}
	public int getDMG()
	{
		return this.dmg;
	}
	public double[] getposition()
	{
		// TODO Auto-generated method stub
		double[]position = new double[2];
		position[0] = this.x;
		position[1] = this.y;
		return position;
	}
	public int getGold()
	{
		return this.gold;
	}
}
