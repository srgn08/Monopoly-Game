import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadTxt {
	/**
	 * read text function
	 * @param temp2
	 * @param entry
	 */
	public ReadTxt(ArrayList <String> temp2, String entry)
	{
		
	       try{

	          FileReader inputFile = new FileReader(entry);

	          BufferedReader bufferReader = new BufferedReader(inputFile);

	          String line;

	          while ((line = bufferReader.readLine()) != null)   {
	        	  temp2.add(line);
	          }
	          bufferReader.close();
	       }catch(Exception e){
	          System.out.println("Error while reading file line by line:" + e.getMessage());                      
	       }
	}
	
	
	
	
}


