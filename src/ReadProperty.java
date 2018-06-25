import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class ReadProperty  {
	
		/**
		 * read property.json function
		 * @param land_id
		 * @param land_name
		 * @param land_cost
		 * @param station_id
		 * @param station_name
		 * @param station_cost
		 * @param company_id
		 * @param company_name
		 * @param company_cost
		 * @throws org.json.simple.parser.ParseException
		 */
		public void read(ArrayList <String>land_id,ArrayList <String>land_name,ArrayList <String>land_cost,
				ArrayList <String>station_id,ArrayList <String>station_name,ArrayList <String>station_cost,
				ArrayList <String>company_id,ArrayList <String>company_name,ArrayList <String>company_cost) throws org.json.simple.parser.ParseException
		{

	try {

		FileReader reader =new FileReader ("property.json");

		    JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
			JSONArray array1 = (JSONArray) jsonObject.get("1");
			JSONObject obj;
			JSONObject obj2;
			JSONObject obj3;

		    for(int i=0;i<array1.size();i++){
			obj=(JSONObject)array1.get(i);
			land_id.add((String) obj.get("id"));
			obj2=(JSONObject)array1.get(i);
			land_name.add((String) obj2.get("name"));
			obj3=(JSONObject)array1.get(i);
			land_cost.add((String) obj3.get("cost"));
			}
	
		JSONArray array2 = (JSONArray) jsonObject.get("2");
		for(int i=0;i<array2.size();i++){
			obj=(JSONObject)array2.get(i);
			station_id.add((String) obj.get("id"));
			obj2=(JSONObject)array2.get(i);
			station_name.add((String) obj2.get("name"));
			obj3=(JSONObject)array2.get(i);
			station_cost.add((String) obj3.get("cost"));
			}
		
		JSONArray array3 = (JSONArray) jsonObject.get("3");
		for(int i=0;i<array3.size();i++){
			obj=(JSONObject)array3.get(i);
			company_id.add((String) obj.get("id"));
			obj2=(JSONObject)array3.get(i);
			company_name.add((String) obj2.get("name"));
			obj3=(JSONObject)array3.get(i);
			company_cost.add((String) obj3.get("cost"));
			}
		
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e2) {
		e2.printStackTrace();
	}
  
	}
	
}
