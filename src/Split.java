import java.util.ArrayList;


public class Split {

	/**
	 * split function
	 * @param temp2
	 * @param temp3
	 * @param temp4
	 */
	public void split(ArrayList <String> temp2,ArrayList <String> temp3,ArrayList <String> temp4)
	{
		
		String regex=";";
		for(int i=0;i<temp2.size();i++){
			if(!temp2.get(i).equals("show()")){
			temp3.add(temp2.get(i).split(regex)[0]);
			temp4.add(temp2.get(i).split(regex)[1]);
		}
			else {
				temp3.add(temp2.get(i).split(regex)[0]);
			temp4.add(null);
		}
		}
			
		
		
	}
	
	
}
