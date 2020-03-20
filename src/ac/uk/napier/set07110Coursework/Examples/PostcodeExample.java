package ac.uk.napier.set07110Coursework.Examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;



/**
 * 
 * Example code that shows how to read the iv.csv file which contains the subset of UK post codes starting with iv
 * 
 * The post codes are read from a file, added to a list of type Coordinate and displayed on a map
 * 
 */
public class PostcodeExample {
	
	public static void main(String[] args) {
		//A list of coordinates that will be displayed on a map
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		
		//A try catch block is needed to catch any file input errors 
		try {
			
			//We use a Buffered Reader to read the file line by line
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/iv.csv")));
					
			String line;
			int count = 0;
		
			//continue reading until null is returned when the end of the file has been reached
			while((line = reader.readLine())!= null){
				
				//printing every line is computationally expensive 
				//System.out.println(line);

				
				//we can use the split method of String to extract the individual fields from the comma delimited line to an array
				String[] data = line.split(",");
				
				//fields 1 and 2 hold the latitude and longitude which need converted to type double
				//create a new Coordinate and add it to a list of coordinates
				Coordinate coordinate = new Coordinate(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
				coordinates.add(coordinate);								
			}
			
			reader.close();

			//show the list of coordinates
			gui.MapGui.showMap(coordinates);
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (NumberFormatException e) {			
			e.printStackTrace();
		}
	}
}
