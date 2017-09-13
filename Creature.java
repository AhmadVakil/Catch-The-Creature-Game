package av222gx_assign3.exercise_9;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Creature {

	public static int y;
	public static int x;
	public static int MouseClicked;
	public static int MouseClickedMain;
	public static String URLadr;
	public static String yes="https://cdn3.iconfinder.com/data/icons/security-2-1/512/thumb_up-512.png";
	public static String DefaultImage="http://vignette4.wikia.nocookie.net/callofduty/images/5/5b/Specialty_airdrop_juggernaut_small.png/revision/latest?cb=20111112094909";
	public static Image yesImage;

	public static ImageView Creature() {

		 Image OnlineImage = new Image(DefaultImage);
	     ImageView Viewer = new ImageView();
	     URL img =null;
	      
	       try{
	    	 img=new URL(URLadr);
	    	 OnlineImage = new Image(URLadr);
	    	 Viewer.setImage(OnlineImage);
	    	
	     } catch (MalformedURLException e) {
		    	Alert Info = new Alert(AlertType.INFORMATION);
		 		Info.setTitle("Wrong URL address!");
		 		Info.setHeaderText("Error with online PNG/JPG or Image file.");
		 		Info.setContentText("The application will try to use it's own online PNG file.");
		 		Info.showAndWait();
			    e.printStackTrace();
			}
		 Viewer.setImage(OnlineImage);
	     Viewer.setFitWidth(110);
	     Viewer.setFitHeight(110);
	     
	     
	     Viewer.setOnMousePressed((e) ->{

				MouseClicked=MouseClicked+(e.getClickCount());
				MouseClickedCounter(e.getClickCount());
	             System.out.println("Your Score: "+MouseClickedMain); 
	              
	        });
	     
		return Viewer;
	}
	
	
	
	public static int MouseClickedCounter(int a){
		MouseClickedMain+=a;
		return a;
	}
	
	
}

