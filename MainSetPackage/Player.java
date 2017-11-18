/**
 * This class is the Player class that contains all attrbiutes and methods of the any Player in the game
 * @author Anmol, Rajat
 */

package MainSetPackage;

import java.util.ArrayList;
import MainSetPackage.Grid.Cell;
import javafx.scene.paint.Color;

public class Player 
{
	private Color color;
	public String playerName;
	public int[] griddim;
	int playernum;
	public int flag= 0;
	
	/**
	 * 
	 * @param n Number of the Player
	 * @param s Name of the Player
	 * @param color Color of the Player
	 * @param gridSize Size of the Grid
	 */
	Player(int n,String s, Color color, int[] gridSize)
	{
		this.playerName= s;
		this.color= color;
		//grid = d;
		this.griddim= gridSize;
		playernum=n;
	}
	
	/**
	 * This method is called when player takes a turn and chain reaction occurs!
	 * @param cell Cell on which this method is called and then on its neighbours(if required)
	 */
	public void subtakeTurn(Cell cell)
	{//check if you are constantly changing the color
		cell.color= this.color;
		if(cell.numOrbs< cell.criticalMass-1)
		{
			cell.addOrb();//okay
		}
		else
		{
			ArrayList<Cell> cellist= cell.getNeighbour();//check
			cell.orb.getChildren().clear();//okay
			cell.numOrbs= 0;
			cell.translate(this,cellist,cell.color);
			cell.color= null;
		}
	}
	
	/**
	 * This method is called when player takes a turn on any cell
	 * @param cell
	 */
	public void takeTurn(Cell cell)//check if you are constantly changing the color
	{
		cell.color= this.color;
		if(cell.numOrbs< cell.criticalMass-1)
		{
			cell.addOrb();//okay
		}
		else
		{
			ArrayList<Cell> cellist= cell.getNeighbour();//check
			cell.orb.getChildren().clear();//okay
			cell.numOrbs= 0;
			cell.translate(this,cellist,cell.color);
			cell.color= null;
			
		}
		for(int i=0 ; i<Grid.grid.length ; i++)
		{
			for(int j=0 ; j<Grid.grid[0].length ; j++)
			{
				Grid.grid[i][j].box.setStroke(Grid.playerList.get(Grid.playerturn).getColor());
				Grid.grid[i][j].box.setStrokeWidth(2);
			}
		}
	}
	
	/**
	 * 
	 * @return The color of the Player itself
	 */
	public Color getColor()
	{
		return this.color;
	}
}