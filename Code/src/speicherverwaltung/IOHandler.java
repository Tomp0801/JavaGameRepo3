package speicherverwaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class IOHandler 
{

	
	/**
	 * Speichert eine Liste in einer Datei
	 * 
	 * @param liste wird in einer Datei gespeichert
	 * @param path weg der Datei in der Die Liste hineingeschrieben wird. Ist keine Datei vorhanden, wird eine neue erstellt
	 */
//	public static void speichereListeInEineNeueDatei(ArrayList<Object> liste , Path path ) 
//	{
//		File file = new File(path.toUri()); 
//		if (file.exists())
//		{
//			
//		}
//		else
//		{
//			
//		}
//	}
	
	/**
	 * diese Methode ist zum ueben. Sie soll einen String in eine Datei schreiben
	 * @param text
	 * @return
	 */
	public static void schreibeEinenString(String text)
	{
		String pathUserHome = System.getProperty("user.home");
		File file = new File(pathUserHome+"/Test_Java_IOHandler.txt"); 
		try
		{
			file.createNewFile();
		} 
		catch (IOException e) 
		{
			System.out.println("Die Datei "+file.getAbsolutePath()+" konnte nicht erstellt werde");
			e.printStackTrace();
		} 
			Image image = new Image("speicherverwaltung/Erde.jpg"); 
			
		try {
			FileOutputStream schreiben = new FileOutputStream(file);
			try {
				ObjectOutput output = new ObjectOutputStream(schreiben);
				output.writeObject(new Integer(2994));
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			OutputStreamWriter writer = new OutputStreamWriter(schreiben); 
			
//			try {
//				
//				schreiben.write("Hellor Word".getBytes());
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
			
//			try {
//				writer.write("Hello Word");
//				writer.close();
//			} catch (IOException e) {

//				e.printStackTrace();
//			}
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error: Fehler beim schreben in"+file.getAbsolutePath());
			e.printStackTrace();
		} 
		
//			try 
//			{
//				FileWriter schreiben = new FileWriter(file);
//				schreiben.write("Hello Word");
//				schreiben.close();
//			} catch (IOException e) 
//			{
//				System.out.println("Error: Fehler beim schreben in"+file.getAbsolutePath());
//				e.printStackTrace();
//			}
	}

}
