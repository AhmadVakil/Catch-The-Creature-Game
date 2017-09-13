package av222gx_assign3.exercise_9;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Catch_the_Creature extends Application {
	public static int ClickedTime=0;
	public String path="";
	public Creature myCreature;
    public String DefaultImage="http://vignette4.wikia.nocookie.net/callofduty/images/5/5b/Specialty_airdrop_juggernaut_small.png/revision/latest?cb=20111112094909";
	
	public void start(Stage MyStage) throws InterruptedException  {
	   
		Label URL = new Label();
		 URL.setText("Please paste the URL address of the PNG/JPG icon to use it as our player:\nOr press OK to use default online Image.");
			URL.setFont(Font.font ("Arial", 17));
   	
			Label Clicked=new Label();
				
				
				 TextField URLAddress=new TextField();
				 URLAddress.setPrefSize(700, 15);
		
				  	Button OK = new Button();
				  	OK.setPrefSize(140, 50);
				  	OK.setText("OK");
				  	OK.setFont(Font.font ("Arial", 17));
				  	
   		        Stage URLStage = new Stage();
   		        URLStage.setResizable(false);
   		        HBox HB=new HBox();
   		        HB.getChildren().addAll(URL,URLAddress,OK);
   		        HBox.setMargin(URLAddress, new Insets(50,0,0,-560));
   		        HBox.setMargin(OK, new Insets(100,0,0,-140));

   		      OK.setOnAction(new EventHandler<ActionEvent>() {
      		   		 public void handle(ActionEvent event) {
      		   			 if(URLAddress.getText().isEmpty()){
      		   				 myCreature.URLadr=myCreature.DefaultImage;
      		   			     URLStage.close();
      		   			 }else{
      		   			 Creature MyCreature =new Creature();
      		   			 MyCreature.URLadr=URLAddress.getText();
      		   		     URLStage.close();
      		   			 }
      		       	 }
      		       });

   		       
   		        Scene URLScene = new Scene(HB, 700, 150);
   		        URLStage.setScene(URLScene);
   		        URLStage.showAndWait();
   		     
   		        Group MainPane=new Group();
   		        MainPane.getChildren().addAll(Creature.Creature());
   		        
   		        Group Labels= new Group();
   		        Labels.getChildren().addAll(Clicked);
   		        
   		          Stage ScoreStage = new Stage();
   		        	ScoreStage.setResizable(false);
   		        		Scene ScoreScene = new Scene(Labels, 250, 150);
   		        		ScoreStage.setScene(ScoreScene);
   		        		ScoreStage.setTitle("Your Scores");
   		        		
   		        		Clicked.setFont(Font.font ("Arial", 20));
   		        
   		    Scene MyScene = new Scene(MainPane, 690, 690);
   			MyStage.setResizable(false);
   			MyStage.setScene(MyScene);
   		    MyStage.show();
   		    ScoreStage.show();
   		
   		 
   		
   		 new AnimationTimer() {
   			boolean Appear = true;
   			int Time = 0;
   			
   			@Override
   			public void handle(long now) {
   				
   				Random a=new Random();
   	        	int xx=a.nextInt(500);
   	        	int yy=a.nextInt(500);
   				if(Appear)
   				{
   				if(Time <= 200)
   				Time += 10;
   				else if(Time >= 200)
   				Appear=false;
   				}
   				else
   				{
   				if(Time >= 0)
   				Time -= 30;
   				else if (Time <= 0)
   				Appear = true;
   				}
   				if (Time==200){
   					MainPane.setTranslateX(xx);
   					MainPane.setTranslateY(yy);
   				    Clicked.setText(" You could Click: "+Creature.MouseClickedMain+" Times");
   				      if (Creature.MouseClickedMain>5){
   				    	Clicked.setText(" You could Click: "+Creature.MouseClickedMain+" Times\nWOW! You Are Fast");
   				      }
   				}
   				
   			}
   			}.start();
   		    
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	    Application.launch(args);
	    
	   
	  }
}
	

