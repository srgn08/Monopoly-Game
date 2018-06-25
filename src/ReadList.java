
	import org.json.simple.*;
import org.json.simple.parser.JSONParser;

	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

	public class ReadList  {
		
		public  void read(ArrayList <String>list,ArrayList <String>list2) throws org.json.simple.parser.ParseException
		{
			/**
			 * read list.json function
			 */
		try {
			FileReader reader =new FileReader ("list.json");
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
			JSONArray chanceList = (JSONArray) jsonObject.get("chanceList");
			JSONObject obj2;
				for(int i=0;i<chanceList.size();i++){
				obj2=(JSONObject)chanceList.get(i);
				list.add((String) obj2.get("item"));
				}			
				JSONArray chestList = (JSONArray) jsonObject.get("communityChestList");
				JSONObject obj3;
				for(int k=0;k<chestList.size();k++){
				obj3=(JSONObject)chestList.get(k);
				list2.add((String) obj3.get("item"));				
				}
					
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}	   
		}		
	}