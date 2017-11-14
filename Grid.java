package MainSetPackage;
//as soon as the player keeps getting eliminated skip his turn!
import java.io.*;
import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Grid extends MainPage implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pane root = new Pane();
	public int[] gridSize;
	boolean playable;
	//vary the color of the top line always with the turn
	public static ArrayList<Player> playerList;
	public static Cell[][] grid;
	public Player currentPlayer;
	public static int playerturn= 0;
	
	public Grid(int[] gridSize, ArrayList<Player> playerList)
	{
		this.gridSize= gridSize;
		this.playerList= playerList;
		this.grid= new Cell[gridSize[0]][gridSize[1]];
	}
	
	public Parent createContent(int[] gridSize, ArrayList<Player> playerList) throws FileNotFoundException
	{
		root.setPrefSize(700,1000);
		
		//Add the blue separator line
		Line topLine = new Line();
		topLine.setStroke(Color.BLUE);
		topLine.setStartX(0); 
		topLine.setStartY(50); 
		topLine.setEndX(800); 
		topLine.setEndY(50);
		topLine.setStrokeWidth(4);
		root.getChildren().add(topLine);
		
		//Add heading
		Text heading = new Text();
		heading.setText("Chain Reaction");
		heading.setTextOrigin(VPos.TOP);
		heading.setFont(Font.font(36));
		root.getChildren().add(heading);
		
		//Add buttons
		Button newGameBtn = new Button();
		newGameBtn.setText("New Game");
		newGameBtn.setLayoutX(460);
		newGameBtn.setLayoutY(10);
		newGameBtn.setMinWidth(100);
		root.getChildren().add(newGameBtn);
		
		Button exitBtn = new Button();
		exitBtn.setText("Exit");
		exitBtn.setLayoutX(580);
		exitBtn.setLayoutY(10);
		exitBtn.setMinWidth(100);
		root.getChildren().add(exitBtn);
		
		Button undoBtn = new Button();
		undoBtn.setText("Undo");
		undoBtn.setLayoutX(340);
		undoBtn.setLayoutY(10);
		undoBtn.setMinWidth(100);
		root.getChildren().add(undoBtn);
		
		//Add the cells
		for(int i=0 ; i<gridSize[0] ; i++)
		{
			for(int j=0 ; j<gridSize[1] ; j++)
			{
				Cell box;
				if((i==0 || i==gridSize[0]-1) && (j==0 || j==gridSize[1]-1))
				{
					box = new Cell(2,i,j);
					grid[i][j]=box;
				}
				else if(i==0 || i==gridSize[0]-1 || j==0 || j==gridSize[1]-1)
				{
					box = new Cell(3,i,j);
					grid[i][j]=box;
				}
				else
				{
					box = new Cell(4,i,j);
					grid[i][j]=box;
				}
				if(gridSize[0]==15 && gridSize[1]==10)
				{
					box.setTranslateX(50+(j * 60));
	                box.setTranslateY(75+(i * 60));
				}
				else
				{
					box.setTranslateX(50+(j * 100));
	                box.setTranslateY(75+(i * 100));
				}
                root.getChildren().add(box);
			}
		}
		return root;
	}

	public class Cell extends StackPane implements Serializable
	{
		int criticalMass;
		int orbSize;
		int cellSize;
		boolean isEmpty;
		Color color;
		Group orb;
		int numOrbs=0;
		int[] coordinate = new int[2];
		ArrayList<Cell> neighbours;
		Rectangle box;
		Cell(int criticalMass,int x,int y)
		{
			orb = new Group();
			coordinate[0]=x;
			coordinate[1]=y;
			this.criticalMass=criticalMass;
			isEmpty=true;
			neighbours = new ArrayList<Cell>();
			if(gridSize[0]==15)
			{
				cellSize = 60;
				orbSize = 12;
			}
			else
			{
				cellSize = 100;
				orbSize = 20;
			}
			box = new Rectangle(cellSize,cellSize);
			box.setFill(null);
			box.setStroke(playerList.get(0).getColor());
			setAlignment(Pos.CENTER);
			getChildren().add(box);
			
			setOnMouseClicked(event -> 
			{
				currentPlayer= playerList.get(playerturn);
				if(this.color== currentPlayer.getColor() || this.color== null)
				{
					this.color= currentPlayer.getColor();//okay
					currentPlayer.takeTurn(this);
				}	
            });
			getChildren().add(orb);
		}
		
		public ArrayList<Cell> getNeighbour()//okay
		{
			ArrayList<Cell> list= new ArrayList<Cell>();
			if((this.coordinate[1]==0))
			{
				list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
				if(this.coordinate[0]==0)
				{
					list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
				}
				else if(this.coordinate[0]== gridSize[1]-1)
				{
					list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				}
				else
				{
					list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
					list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				}
			}
			else if((this.coordinate[1]==gridSize[0]-1))
			{
				list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
				if(this.coordinate[0]==0)
				{
					list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
				}
				else if(this.coordinate[0]== gridSize[1]-1)
				{
					list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				}
				else
				{
					list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
					list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				}
			}
			else if(this.coordinate[0]== 0)
			{
				list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
				if(this.coordinate[1]==0)
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
				}
				else if(this.coordinate[1]==gridSize[0]-1)
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
				}
				else
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
					list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
				}
			}
			else if(this.coordinate[0]== gridSize[1]-1)
			{
				list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				if(this.coordinate[1]==0)
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
				}
				else if(this.coordinate[1]== gridSize[0]-1)
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
				}
				else
				{
					list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
					list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
				}
			}
			else//means it lies somewhere in between
			{
				list.add(grid[this.coordinate[0]][this.coordinate[1]+1]);
				list.add(grid[this.coordinate[0]+1][this.coordinate[1]]);
				list.add(grid[this.coordinate[0]-1][this.coordinate[1]]);
				list.add(grid[this.coordinate[0]][this.coordinate[1]-1]);
			}
			return list;
		}
		
		public void addOrb()
		{
			orb.getChildren().clear();
			if(numOrbs==0)
			{
				Sphere sphere = new Sphere(orbSize);
				sphere.setMaterial(new PhongMaterial(this.color));
				orb.getChildren().add(sphere);
			}
			else if(numOrbs==1)
			{
				Sphere sphere_1 = new Sphere(orbSize);
				sphere_1.setMaterial(new PhongMaterial(this.color));
				sphere_1.setTranslateX((cellSize - (3.5)*(orbSize))/2 + orbSize);
				Sphere sphere_2 = new Sphere(orbSize);
				sphere_2.setMaterial(new PhongMaterial(this.color));
				sphere_2.setTranslateX((cellSize - (3.5)*(orbSize))/2 + (2.5)*orbSize);
				orb.getChildren().addAll(sphere_1,sphere_2);
					
			}
			else if(numOrbs==2)
			{
				Sphere sphere_3 = new Sphere(orbSize);
				sphere_3.setMaterial(new PhongMaterial(this.color));
				sphere_3.setTranslateX((cellSize - (3.5)*(orbSize))/2 + (2.5)*orbSize);
				Sphere sphere_4 = new Sphere(orbSize);
				sphere_4.setMaterial(new PhongMaterial(this.color));
				sphere_4.setTranslateX((cellSize - (3.5)*(orbSize))/2 + orbSize);
				Sphere sphere_5 = new Sphere(orbSize);
				sphere_5.setMaterial(new PhongMaterial(this.color));
				sphere_5.setTranslateX((cellSize - (3.5)*(orbSize))/2 + (1.75)*orbSize);
				sphere_5.setTranslateY(cellSize/4);
				orb.getChildren().addAll(sphere_3,sphere_4,sphere_5);
			}
			numOrbs++;
			RotateTransition rotater = new RotateTransition();
			if(numOrbs==this.criticalMass-1)
				rotater.setDuration(Duration.seconds(2));
			else
				rotater.setDuration(Duration.seconds(8));
			rotater.setNode(orb);
			rotater.setFromAngle(0);
			rotater.setToAngle(360);
			rotater.setAutoReverse(false);
			rotater.setCycleCount(Timeline.INDEFINITE);
			rotater.setInterpolator(Interpolator.LINEAR);
			rotater.play();	
		}
	}
	
	public static void main(int[] gridSize, ArrayList<Player> playerList) throws FileNotFoundException
	{
		Stage primaryStage= new Stage();
		Grid mainGrid= new Grid(gridSize, playerList);
		primaryStage.setScene(new Scene(mainGrid.createContent(gridSize, playerList)));
        primaryStage.show();
	}
}