
public class Player extends User{
	/**
	 * player attributes are here and this attributes type is private
	 */
	private int position;
	private int punish;
	public int[] owned=new int[100];
	public String[]owned_name=new String[100];
	private int dice;
	
	
	
  /**
   * setter and getter methods
   * @return
   */
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPunish() {
		return punish;
	}

	public void setPunish(int punish) {
		this.punish = punish;
	}

	

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public Player(String name,int money,int position,int punish,int[]owned,int dice)
	{
		super(name,money);
		this.dice=dice;
		this.position=position;
		this.owned=owned;
		this.punish=punish;
	}
	
	public Player()
	{
		
	}
	
	
}
