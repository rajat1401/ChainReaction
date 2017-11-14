package MainSetPackage;

import java.util.ArrayList;

import MainSetPackage.Grid.Cell;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Player 
{
	private Color color;
	public String playerName;
	public int[] griddim;
	int playernum;
	public int flag= 0;
	
	Player(int n,String s, Color color, int[] gridSize)
	{
		this.playerName= s;
		this.color= color;
		//grid = d;
		this.griddim= gridSize;
		playernum=n;
	}
	
	public int checkColor(Cell cell){
		int result= 0;
		for(int i=0; i<Grid.playerList.size(); i++)
		{
			if(cell.color== Grid.playerList.get(i).getColor())
			{
				result= i;
				break;
			}
		}
		return result;
	}
	
	public void takeTurn(Cell cell)
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
			cell.color= null;
			for(int i=0; i<cellist.size(); i++){
				takeTurn(cellist.get(i));//okay
			}
		}
		if(flag==1){
			int[] freqarray= new int[Grid.playerList.size()];
			for(int i=0; i<Grid.grid.length; i++){
				for(int j=0; j<Grid.grid[0].length; j++){
					if(Grid.grid[i][j].color!= null){
						freqarray[checkColor(Grid.grid[i][j])]++;
					}
				}
			}
			for(int i=0; i<freqarray.length; i++){
				if(freqarray[i]== 0){
					Grid.playerList.remove(i);
				}
			}
			if(Grid.playerList.size()== 1){//declares him as the winner. okay
				System.out.println(Grid.playerList.get(0).playerName + " has won the Game!!!!");
				//add some functionality
			}
		}
		
		if(Grid.playerturn>= Grid.listPlayers.size()-1){
			Grid.playerturn= 0;
			for(int i=0; i<Grid.playerList.size(); i++){
				Grid.playerList.get(i).flag= 1;//means one round has been completed! okay
			}
		}else{
			Grid.playerturn++;
		}
		
		for(int i=0 ; i<Grid.grid.length ; i++)
		{
			for(int j=0 ; j<Grid.grid[0].length ; j++)
			{
				Grid.grid[i][j].box.setStroke(Grid.playerList.get(Grid.playerturn).getColor());
			}
		}
	}
	
	public Color getColor()
	{
		return this.color;
	}
}