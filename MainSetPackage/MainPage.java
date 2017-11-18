/**
 * This class is the class for the Main Page
 * 
 * @author Rajat, Anmol
 */

package MainSetPackage;
//DEFAULT SETTINGS ARE ADDED UNDER SETOnACTION LISTENER OF PLAYGAME AND FLAGS.
import java.io.FileNotFoundException;
import java.util.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import MainSetPackage.Settings;

class PlayersNotSelectedException extends Exception{
	/**
	 * 
	 * @param message To be displayed when this exception gets thrown
	 */
	public PlayersNotSelectedException(String message){
		super(message);
	}
}


public class MainPage extends Application{
	public static int numPlayers= 0;
	public static int[] gridSize= new int[2];
	public static Color[] colorList= new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.ORANGE, Color.WHITE};
	public static ArrayList<Player> listPlayers= new ArrayList<Player>();
	
	/**
	 * 
	 * @param args inputs
	 * @throws Exception General type exception catching
	 * @throws NullPointerException Null Pointer Exception catching 
	 */
	public static void main(String[] args) throws Exception, NullPointerException{
		launch(args);
	}
	
	/**
	 * Abstract method executed by the Application thread(takes input via GUI from user)
	 */
	@Override
	public void start(Stage mainstage) throws Exception, NullPointerException{
		mainstage.setTitle("Main Page");

		ChoiceBox<String> cb= new ChoiceBox<String>();
		cb.setItems(FXCollections.observableArrayList("2", "3", "4", "5", "6", "7", "8"));
		

		ChoiceBox<String> cb2= new ChoiceBox<String>();
		cb2.setItems(FXCollections.observableArrayList("9X6", "15X10"));

		Button btn2= new Button("Resume Game!");

		Button btn3= new Button("Settings");
		btn3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				String choice= cb.getSelectionModel().getSelectedItem();
				if(choice!= null){
					numPlayers= Integer.parseInt(choice);
				}else{
					numPlayers= 2;
				}
				
				String choice2= cb2.getSelectionModel().getSelectedItem();
				if(choice2!= null){
					int xxflag= -1;
					for(int i=0; i<choice2.length(); i++){
        				if(choice2.charAt(i)== 'X'){
        					xxflag= i;
        				}
        			}
					gridSize[0]= Integer.parseInt(choice2.substring(0, xxflag));
					gridSize[1]= Integer.parseInt(choice2.substring(xxflag+1, cb2.getSelectionModel().getSelectedItem().toString().length()));
				}else{
					gridSize[0]= 9;
					gridSize[1]= 6;
				}
				// TODO Auto-generated method stub
				String[]args= {"1", "2"};
				try {
					Settings.main(args);
				} catch (BadColorSelectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Button btn = new Button("Play Game");
		
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	listPlayers= new ArrayList<Player>();
            	String choice= cb.getSelectionModel().getSelectedItem();
            	if(choice!= null){
            		numPlayers= Integer.parseInt(choice);
            	}else{
            		numPlayers= 2;
            	}
        		String choice2= cb2.getSelectionModel().getSelectedItem();
        		int xflag= -1;
        		if(choice2!= null){//means no grid size selected(provide a default grid-size)!
        			for(int i=0; i<choice2.length(); i++){
        				if(choice2.charAt(i)== 'X'){
        					xflag= i;
        				}
        			}
        			gridSize[0]= Integer.parseInt(choice2.substring(0, xflag));
        			gridSize[1]= Integer.parseInt(choice2.substring(xflag+1, choice2.length()));
        			
        		}else{//default grid size when not selected
        			gridSize[0]= 9;
        			gridSize[1]= 6;
        		}


            	if(numPlayers< 2){
            		try {
						throw new PlayersNotSelectedException("Please select the number of players again!");
					} catch (PlayersNotSelectedException e) {
						e.printStackTrace();
					}
            	}else{
            		for(int i=0; i<numPlayers; i++){
            			Player p= new Player(i+1,"Player " + Integer.toString(i+1), colorList[i], gridSize);
            			listPlayers.add(p);
            		}
            		try {
						Grid.main(gridSize, listPlayers);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
        });

        VBox root= new VBox();
        HBox hbox2= new HBox();
        Label heading = new Label("CHAIN REACTION");
        heading.setStyle("-fx-font-weight: bold");
        heading.setFont(Font.font(36));
        hbox2.setPadding(new Insets(20, 20, 20, 20));
        hbox2.setAlignment(Pos.TOP_CENTER);
        hbox2.getChildren().add(heading);
        root.getChildren().add(hbox2);
        HBox hbox3= new HBox();
        hbox3.setPadding(new Insets(30, 30, 30, 30));
        hbox3.setSpacing(40);
        Label label1= new Label("Number of Players: ");
        hbox3.getChildren().add(label1);
        hbox3.getChildren().add(cb);
        root.getChildren().add(hbox3);
        HBox hbox4= new HBox();
        hbox4.setPadding(new Insets(30, 30, 30, 30));
        hbox4.setSpacing(40);
        Label label2= new Label("Select Grid Size: ");
        hbox4.getChildren().add(label2);
        hbox4.getChildren().add(cb2);
        root.getChildren().add(hbox4);
        HBox hbox= new HBox();
        hbox.setHgrow(btn, Priority.ALWAYS);
        hbox.setHgrow(btn2, Priority.ALWAYS);
        hbox.setHgrow(btn3, Priority.ALWAYS);
        hbox.setPadding(new Insets(20, 20, 20, 20));
        btn.setMaxWidth(200);
        btn2.setMaxWidth(200);
        btn3.setMaxWidth(200);
        hbox.getChildren().addAll(btn, btn2, btn3);
        root.getChildren().add(hbox);
        Scene scene= new Scene(root, 470, 480);
        root.setStyle("-fx-background-color: #D3D3D3");
        mainstage.setScene(scene);
        mainstage.show();
	}
}
