package Characters;

public class Zombie extends Character{

	private int dmg, hp;
	private double x, y;

	public Zombie(int dmg, int hp, double x, double y)
	{
		super(x, y, hp, dmg);
	}
	public int takeDamage(int num)
	{
		return hp - num;
	}
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
}
