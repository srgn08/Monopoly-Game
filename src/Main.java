import java.util.ArrayList;
import java.io.*;

import org.json.simple.parser.ParseException;


public class Main {
	public static void main(String[] args) throws ParseException, IOException {
		/**
		 * this is 13 array list each array list keep data
		 */
		ArrayList <String> temp2 =new ArrayList<String> ();
		ArrayList <String> temp3=new ArrayList<String> ();
		ArrayList <String> temp4=new ArrayList<String> ();
		ArrayList <String>land_id=new ArrayList<String>();
		ArrayList <String>land_name=new ArrayList<String>();
		ArrayList <String>land_cost=new ArrayList<String>();
		ArrayList <String>station_id=new ArrayList<String>();
		ArrayList <String>station_name=new ArrayList<String>();
		ArrayList <String>station_cost=new ArrayList<String>();
		ArrayList <String>company_id=new ArrayList<String>();
		ArrayList <String>company_name=new ArrayList<String>();
		ArrayList <String>company_cost=new ArrayList<String>();
		ArrayList <String>list=new ArrayList<String>();
		ArrayList <String>list2=new ArrayList<String>();
		/**
		 * write putput.txt
		 */
		File file=new File("output.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		ReadTxt r=new ReadTxt(temp2,args[0]);
		Split s=new Split();
		s.split(temp2,temp3,temp4);
		ReadProperty rp=new ReadProperty();
		rp.read(land_id,land_name,land_cost,station_id,station_name,
				station_cost,company_id,company_name,company_cost);
		ReadList rl=new ReadList();
		rl.read(list,list2);
		Player player1=new Player();
		Player player2=new Player();
		Banker banker=new Banker();
		Operations o=new Operations();
		/**
		 * call initialization function
		 */
		o.initialization(player1,player2,banker);
		o.control(land_id,land_name,land_cost,station_id,station_name,
				station_cost,company_id,company_name,company_cost,list,list2,temp3,temp4,player1,player2,banker,bw);
		/**
		 * close output file
		 */
		bw.close();
		
			
			
	}

}
