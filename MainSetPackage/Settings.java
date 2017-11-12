package MainSetPackage;

import java.util.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import MainSetPackage.MainPage;
import javafx.collections.FXCollections;

class BadColorSelectionException extends Exception{

	public BadColorSelectionException(String message){
		super(message);
	}
}

public class Settings extends MainPage{

	public static void main(String[] args) throws Exception, BadColorSelectionException{
		Stage mainstage= new Stage();
		// TODO Auto-generated method stub
		mainstage.setTitle("Setting Page");
		
		VBox root= new VBox();
		ArrayList<String> liststr= new ArrayList<String>();
		for(int i=0; i<8; i++){
			liststr.add("");
		}
		String[][] colorpalette= {{"red", "#dc143c"}, {"green", "#008000"}, {"blue", "#0000ff"}, {"yellow", "#ffff00"}, {"magenta", "#ff00ff"}, {"cyan", "#00ffff"}, {"orange", "#ffa500"}, {"white", "#ffffff"}};
		/*for(int i=0; i<8; i++){
			HBox hbox= new HBox();
			Label label= new Label("Player " + Integer.toString(i+1) + " settings: ");
			label.setTextFill(Color.web("#ffffff"));
		}*/
		HBox hbox1= new HBox();
		hbox1.setPadding(new Insets(16, 16, 16, 16));
		hbox1.setSpacing(40);
		Label label1= new Label("Player 1 settings: ");
		label1.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker1= new ColorPicker();
		colorpicker1.getStyleClass().add("split-button");
		hbox1.getChildren().addAll(label1, colorpicker1);
		root.getChildren().add(hbox1);
		
		HBox hbox2= new HBox();
		hbox2.setPadding(new Insets(16, 16, 16, 16));
		hbox2.setSpacing(40);
		Label label2= new Label("Player 2 settings: ");
		label2.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker2= new ColorPicker();
		colorpicker2.getStyleClass().add("split-button");
		hbox2.getChildren().addAll(label2, colorpicker2);
		root.getChildren().add(hbox2);
		
		HBox hbox3= new HBox();
		hbox3.setPadding(new Insets(16, 16, 16, 16));
		hbox3.setSpacing(40);
		Label label3= new Label("Player 3 settings: ");
		label3.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker3= new ColorPicker();
		colorpicker3.getStyleClass().add("split-button");
		hbox3.getChildren().addAll(label3, colorpicker3);
		root.getChildren().add(hbox3);
		
		HBox hbox4= new HBox();
		hbox4.setPadding(new Insets(16, 16, 16, 16));
		hbox4.setSpacing(40);
		Label label4= new Label("Player 4 settings: ");
		label4.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker4= new ColorPicker();
		colorpicker4.getStyleClass().add("split-button");
		hbox4.getChildren().addAll(label4, colorpicker4);
		root.getChildren().add(hbox4);
		
		HBox hbox5= new HBox();
		hbox5.setPadding(new Insets(16, 16, 16, 16));
		hbox5.setSpacing(40);
		Label label5= new Label("Player 5 settings: ");
		label5.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker5= new ColorPicker();
		colorpicker5.getStyleClass().add("split-button");
		hbox5.getChildren().addAll(label5, colorpicker5);
		root.getChildren().add(hbox5);
		
		HBox hbox6= new HBox();
		hbox6.setPadding(new Insets(16, 16, 16, 16));
		hbox6.setSpacing(40);
		Label label6= new Label("Player 6 settings: ");
		label6.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker6= new ColorPicker();
		colorpicker6.getStyleClass().add("split-button");
		hbox6.getChildren().addAll(label6, colorpicker6);
		root.getChildren().add(hbox6);
		
		HBox hbox7= new HBox();
		hbox7.setPadding(new Insets(16, 16, 16, 16));
		hbox7.setSpacing(40);
		Label label7= new Label("Player 7 settings: ");
		label7.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker7= new ColorPicker();
		colorpicker7.getStyleClass().add("split-button");
		hbox7.getChildren().addAll(label7, colorpicker7);
		root.getChildren().add(hbox7);
		
		HBox hbox8= new HBox();
		hbox8.setPadding(new Insets(16, 16, 16, 16));
		hbox8.setSpacing(40);
		Label label8= new Label("Player 8 settings: ");
		label8.setTextFill(Color.web("#000000"));
		ColorPicker colorpicker8= new ColorPicker();
		colorpicker8.getStyleClass().add("split-button");
		hbox8.getChildren().addAll(label8, colorpicker8);
		root.getChildren().add(hbox8);
		
		/*btn1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 1: ");
				ChoiceBox<String> cb1= new ChoiceBox<String>();
				cb1.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(0, cb1.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(0).setColor(cb1.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb1, Pos.CENTER);
				child.getChildren().add(cb1);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn2= new Button("Player 2 settings");
		btn2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player: ");
				ChoiceBox<String> cb2= new ChoiceBox<String>();
				cb2.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(1, cb2.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(1).setColor(cb2.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb2, Pos.CENTER);
				child.getChildren().add(cb2);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn3= new Button("Player 3 settings");
		btn3.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 3: ");
				ChoiceBox<String> cb3= new ChoiceBox<String>();
				cb3.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(2, cb3.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(2).setColor(cb3.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb3, Pos.CENTER);
				child.getChildren().add(cb3);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn4= new Button("Player 4 settings");
		btn4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 4: ");
				ChoiceBox<String> cb4= new ChoiceBox<String>();
				cb4.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(3, cb4.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(3).setColor(cb4.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb4, Pos.CENTER);
				child.getChildren().add(cb4);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
				//liststr.add(cb4.getSelectionModel().getSelectedItem());
			}

		});

		Button btn5= new Button("Player 5 settings");
		btn5.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 5: ");
				ChoiceBox<String> cb5= new ChoiceBox<String>();
				cb5.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(4, cb5.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(4).setColor(cb5.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb5, Pos.CENTER);
				child.getChildren().add(cb5);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn6= new Button("Player 6 settings");
		btn6.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 6: ");
				ChoiceBox<String> cb6= new ChoiceBox<String>();
				cb6.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(5, cb6.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(5).setColor(cb6.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb6, Pos.CENTER);
				child.getChildren().add(cb6);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn7= new Button("Player 7 settings");
		btn7.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 7: ");
				ChoiceBox<String> cb7= new ChoiceBox<String>();
				cb7.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(6, cb7.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(6).setColor(cb7.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb7, Pos.CENTER);
				child.getChildren().add(cb7);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});

		Button btn8= new Button("Player 8 settings");
		btn8.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage stage= new Stage();
				Label label= new Label("Color preferences for Player 8: ");
				ChoiceBox<String> cb8= new ChoiceBox<String>();
				cb8.setItems(FXCollections.observableArrayList("red", "green", "blue", "yellow", "magenta", "cyan", "orange", "white"));
				StackPane child= new StackPane();
				Button donebtn= new Button("Done");
				donebtn.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						liststr.set(7, cb8.getSelectionModel().getSelectedItem());
						//MainPage.listPlayers.get(7).setColor(cb8.getSelectionModel().getSelectedItem());
						stage.close();
					}
				});
				child.setAlignment(donebtn, Pos.BOTTOM_RIGHT);
				child.getChildren().add(donebtn);
				child.setAlignment(label, Pos.TOP_LEFT);
				child.getChildren().add(label);
				child.setAlignment(cb8, Pos.CENTER);
				child.getChildren().add(cb8);
				Scene scene= new Scene(child, 250, 200);
				stage.setScene(scene);
				stage.show();
			}

		});*/
		ArrayList<ColorPicker> list= new ArrayList<ColorPicker>(8);
		list.add(colorpicker1);
		list.add(colorpicker2);
		list.add(colorpicker3);
		list.add(colorpicker4);
		list.add(colorpicker5);
		list.add(colorpicker6);
		list.add(colorpicker7);
		list.add(colorpicker8);
		
		Button btn9= new Button("Colors selected!");
		btn9.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				// TODO Auto-generated method stub
				for(int i=0; i<MainPage.numPlayers; i++){
					liststr.set(i, list.get(i).getValue().toString());
				}
				for(int i=0; i<MainPage.numPlayers -1; i++){//while looping replace the liststr.size() with numPlayers to avoid exception
					for(int j=i+1; j<MainPage.numPlayers; j++){
						if(liststr.get(i)== "" || liststr.get(j)== "" || liststr.get(i).equals(liststr.get(j))){
							try {
								throw new BadColorSelectionException("Colors not selected properly. Please select again!");
							} catch (BadColorSelectionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				//override the MainPage.colorList by the elements of liststr. And it is done.
				for(int i=0; i<MainPage.numPlayers; i++){
					MainPage.colorList[i]= liststr.get(i);
					//System.out.println(MainPage.colorList[i]);//WORKS AWESOME
 				}
				mainstage.close();
			}
		});
		HBox hbox9= new HBox();
		hbox9.setHgrow(btn9, Priority.ALWAYS);
        hbox9.setPadding(new Insets(20, 20, 20, 20));
        hbox9.getChildren().add(btn9);
        root.getChildren().add(hbox9);
		root.getChildren().add(btn9);
		Scene scene= new Scene(root, 470, 480);
		root.setStyle("-fx-background-color: #FFFBCC");
		mainstage.setScene(scene);
		mainstage.show();
	}

}

