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
import MainSetPackage.MainPage;
import javafx.collections.FXCollections;

class BadColorSelectionException extends Exception{

	public BadColorSelectionException(String message){
		super(message);
	}
}

public class Settings extends MainPage{

	public static void main(String[] args) throws Exception{
		Stage mainstage= new Stage();
		// TODO Auto-generated method stub
		mainstage.setTitle("Setting Page");
		
		VBox root= new VBox();
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
		btn9.setTranslateX(200);
		btn9.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				// TODO Auto-generated method stub
				for(int i=0; i<MainPage.numPlayers; i++){
					MainPage.colorList[i]= list.get(i).getValue();
				}
				for(int i=0; i<MainPage.numPlayers -1; i++){//while looping replace the liststr.size() with numPlayers to avoid exception
					for(int j=i+1; j<MainPage.numPlayers; j++){
						if(MainPage.colorList[i]== MainPage.colorList[j]){
							try {
								throw new BadColorSelectionException("Colors not selected properly. Please select again!");
							} catch (BadColorSelectionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				mainstage.close();
			}
		});
		HBox hbox9= new HBox();
		hbox9.setHgrow(btn9, Priority.ALWAYS);
        hbox9.getChildren().add(btn9);
        root.getChildren().add(hbox9);
		root.getChildren().add(btn9);
		Scene scene= new Scene(root, 470, 480);
		root.setStyle("-fx-background-color: #D3D3D3");
		mainstage.setScene(scene);
		mainstage.show();
	}

}

