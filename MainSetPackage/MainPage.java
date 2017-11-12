package MainSetPackage;

import java.util.*;
import javax.imageio.ImageIO;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
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

	public PlayersNotSelectedException(String message){
		super(message);
	}
}


public class MainPage extends Application{
	public static int numPlayers= 0;
	public static int[] gridSize= new int[2];
	public static String[] colorList= new String[]{"red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"};
	//public static ArrayList<Player> listPlayers= new ArrayList<Player>();

	public static void main(String[] args) throws Exception, BadColorSelectionException{
		launch(args);
	}

	@Override
	public void start(Stage mainstage) throws Exception, BadColorSelectionException{
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
				numPlayers= Integer.parseInt(cb.getSelectionModel().getSelectedItem());
				gridSize[0]= Character.getNumericValue(cb2.getSelectionModel().getSelectedItem().charAt(0));
				gridSize[1]= Character.getNumericValue(cb2.getSelectionModel().getSelectedItem().charAt(2));
				/*for(int i=0; i<numPlayers; i++){
    				Player one= new Player("Player " + Integer.toString(i+1), colorList[i], gridSize);
    				listPlayers.add(one);
    			}*/	
				// TODO Auto-generated method stub
				String[] args= new String[]{"1", "2"};//NO USE.
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
            	String choice= cb.getSelectionModel().getSelectedItem().toString();
        		numPlayers= Integer.parseInt(choice);
        		String choice2= cb2.getSelectionModel().getSelectedItem().toString();
        		if(!choice2.equals("")){//means no grid size selected(provide a default grid-size)!
        			gridSize[0]= Integer.parseInt(Character.toString(choice2.charAt(0)));
        			gridSize[1]= Integer.parseInt(Character.toString(choice2.charAt(2)));
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
            		/*for(int i=0; i<numPlayers; i++){
            			Player p= new Player("Player " + Integer.toString(i+1), colorList[i], gridSize);
            			listPlayers.add(p);
            		}*/	
            	}
            }
        });

        VBox root= new VBox();
        Label label= new Label("CHAIN REACTION");
        label.setStyle("-fx-font-weight: bold");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.web("#000000"));
        HBox hbox2= new HBox();
        hbox2.setPadding(new Insets(20, 20, 20, 20));
        hbox2.setAlignment(Pos.TOP_CENTER);
        hbox2.getChildren().add(label);
        root.getChildren().add(hbox2);
        /*Image image = new Image(getClass().getResourceAsStream("Reaction.jpg"));
        Label label3 = new Label("", new ImageView(image));*/
        //label3.setWrapText(true);
        //root.setAlignment(label3, Pos.TOP_RIGHT);
        //root.getChildren().add(label3);
        HBox hbox3= new HBox();
        hbox3.setPadding(new Insets(30, 30, 30, 30));
        hbox3.setSpacing(40);
        Label label1= new Label("Number of Players: ");
        label1.setTextFill(Color.web("#ffffff"));
        hbox3.getChildren().add(label1);
        hbox3.getChildren().add(cb);
        root.getChildren().add(hbox3);
        //root.setAlignment(label1, Pos.TOP_LEFT);
        //root.getChildren().add(label1);
        //root.setAlignment(cb, Pos.TOP_CENTER);
        //root.getChildren().add(cb);
        HBox hbox4= new HBox();
        hbox4.setPadding(new Insets(30, 30, 30, 30));
        hbox4.setSpacing(40);
        Label label2= new Label("Select Grid Size: ");
        label2.setTextFill(Color.web("#ffffff"));
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
        //root.setAlignment(label2, Pos.CENTER_LEFT);
        //root.getChildren().add(label2);
        //root.setAlignment(cb2, Pos.CENTER);
        //root.getChildren().add(cb2);
        //root.setAlignment(btn, Pos.BOTTOM_RIGHT);
        //root.getChildren().add(btn);
        //root.setAlignment(btn2, Pos.BOTTOM_LEFT);
        //root.getChildren().add(btn2);
        //root.setAlignment(btn3, Pos.BOTTOM_CENTER);
        //root.getChildren().add(btn3);
        //root.getChildren().add(tileButtons);
        Scene scene= new Scene(root, 470, 480);
        root.setStyle("-fx-background-color: #66cccc");
        mainstage.setScene(scene);
        mainstage.show();
	}

}
