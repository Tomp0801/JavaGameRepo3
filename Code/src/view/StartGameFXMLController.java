package view;

import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import audio.Musikspieler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

/**
 * Das Startmenu. Dies ist das erste was der Spiele zusehen bekommt.
 * 
 * @author Dennis
 *
 */
public class StartGameFXMLController implements Initializable, Runnable
{
	/**
	 * drehende Erdkugel 
	 */
	@FXML
	private Sphere erdkugel; 
		
	/**
	 * Hintergrund der Scene
	 */
	@FXML
	private Canvas hintergrund; 
	
	/**
	 * Eine Box mit MenuItems
	 */
	@FXML
	private VBox startMenuBox;
	
	/**
	 * Ein Button um ein Einzelspielerspiel zustarten
	 */
	@FXML
	private Button einzelspielerButton;
	
	/**
	 * Ein Button um ein Mehrspielerspiel zu starten
	 */
	@FXML
	private Button mehrspielerButton;
	
	/**
	 * ein Button um die Einstellungen zu oeffnen
	 */
	@FXML
	private Button einstellungenButton;
	
	/**
	 * Ein Buttun um ein Zusatzmenu zu oeffnen
	 */
	@FXML
	private Button mehrButton;
	
	/**
	 * Ein Button um das Spiel zu beenden
	 */
	@FXML
	private Button endeButton;
	
	
	/**
	 * initialisiert den Controller
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//Musik startet
		Musikspieler musik = Musikspieler.getInstance();
		musik.starteMusik();
		
		
		//Bild der Erde wird auf der Kugel gelegt
        Image image = new Image("view/Erde.jpg"); 
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseMap(image);
        erdkugel.setMaterial(material1);
    
        //schwarzer Hintergrund wird erstellt
        hintergrund.setWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        hintergrund.setHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight());  
		GraphicsContext graphic = hintergrund.getGraphicsContext2D();
		graphic.setFill(Color.BLACK);
		graphic.fillRect(0, 0, hintergrund.getWidth(), hintergrund.getHeight());	
		
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	
	/**
	 * das Drehen der Erdkugel
	 */
	@Override
	public void run() 
	{
		int radius=0;
		boolean zoom = true;
		long rotation = 0; 
		erdkugel.setRotationAxis(Rotate.Y_AXIS);
		while(true)
		{
			try 
			{
				Thread.sleep(80);
				if (zoom == true)
				{
					erdkugel.setRadius(radius);
					radius++;
				}
				
				erdkugel.setRotate(rotation);
				rotation++; 
				
				//ist das maximale Wert von der Variable rotation erreiccht, dann setze rotation auf 0
				if (rotation == Long.MAX_VALUE)
					rotation = 0; 
				
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			if (radius >= 200)
			{
				zoom = false;;
			}
		}		
	}
	
	
	/**
	 * verwaltet die ActionEvents der Buttons 
	 */
	@FXML
	private void actionButton(ActionEvent e)
	{
		if (e.getSource() == einzelspielerButton)
		{
			System.out.println("Einzelspielerfunktion noch nicht Vorhanden");
		}
		
		else if (e.getSource() == mehrspielerButton)
		{
			//erstellt eine neue Scene
			StageController.getInstance().wechselScene(SceneEnum.NETZWERK);
		}
		else if (e.getSource() == einstellungenButton)
		{
			System.out.println("Einstellungen noch nicht Vorhanden");
		}
		else if (e.getSource() == mehrButton)
		{
			System.out.println("Mehrfunktion noch nicht Vorhanden");
		}
		else if (e.getSource() == endeButton)
		{
			System.out.println("Spiel wurde beendet");
			System.exit(-1);
		}
	}
}
