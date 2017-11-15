package MainSetPackage;

import java.util.ArrayList;

import MainSetPackage.Grid.Cell;
import java.util.concurrent.TimeUnit;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
			cell.color= null;
			/*for(int i=0; i<cellist.size(); i++){
			 	if(cell.coordinate[0]> cellist.get(i).coordinate[0] && cell.coordinate[1]== cellist.get(i).coordinate[1]){
					Grid.translate("left", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else if(cell.coordinate[0]< cellist.get(i).coordinate[0] && cell.coordinate[1]== cellist.get(i).coordinate[1]){
					Grid.translate("right", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else if(cell.coordinate[0]== cellist.get(i).coordinate[0] && cell.coordinate[1]< cellist.get(i).coordinate[1]){
					Grid.translate("down", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else{
					Grid.translate("up", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}
			}*/
			for(int i=0; i<cellist.size(); i++){
				subtakeTurn(cellist.get(i));//okay
			}
		}
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
			/*for(int i=0; i<cellist.size(); i++){
			 	if(cell.coordinate[0]> cellist.get(i).coordinate[0] && cell.coordinate[1]== cellist.get(i).coordinate[1]){
					Grid.translate("left", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else if(cell.coordinate[0]< cellist.get(i).coordinate[0] && cell.coordinate[1]== cellist.get(i).coordinate[1]){
					Grid.translate("right", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else if(cell.coordinate[0]== cellist.get(i).coordinate[0] && cell.coordinate[1]< cellist.get(i).coordinate[1]){
					Grid.translate("down", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}else{
					Grid.translate("up", Grid.grid.length, cell.coordinate[0], cell.coordinate[1]);
				}
			}*/
			for(int i=0; i<cellist.size(); i++){
				subtakeTurn(cellist.get(i));//okay
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
			for(int i=Grid.playerList.size()-1; i>=0; i--){
				if(freqarray[i]== 0){
					Grid.playerList.remove(i);
				}
			}
			if(Grid.playerList.size()== 1){//declares him as the winner. okay
				Stage winstage= new Stage();
				winstage.setTitle("End of Game");
				VBox vbox= new VBox();
				HBox hbox= new HBox();
				Label label= new Label(Grid.playerList.get(0).playerName + " has won the Game!!!");
				label.setFont(Font.font(28));
				label.setWrapText(true);
		        hbox.setPadding(new Insets(20, 20, 20, 20));
				label.setTextFill(Grid.playerList.get(0).color);
				label.setStyle("-fx-font-weight: bold");
				hbox.getChildren().add(label);
				vbox.getChildren().add(hbox);
				Scene scene= new Scene(vbox, 300, 250);
				vbox.setStyle("-fx-background-color: #D3D3D3");
				winstage.setScene(scene);
				winstage.show();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.exit(0);
				//System.out.println(Grid.playerList.get(0).playerName + " has won the Game!!!!");
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