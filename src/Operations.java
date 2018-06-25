import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Operations {
	 int final3=0;
	 int final2=0;
	public Operations()
	{
		
	}
	/**
	 * Gamed money and name initialization
	 * @param player1
	 * @param player2
	 * @param banker
	 */
	public void initialization(Player player1,Player player2,Banker banker){
	player1.setMoney(15000);
	player1.setName("Player 1");
	player2.setMoney(15000);
	player2.setName("Player 2");
	banker.setMoney(100000);
	banker.setName("Banker");
	}
	/**
	 * rent function 
	 * @param player
	 * @param cost
	 * @return
	 */
	public int landRent(Player player, int cost)
	{
		int total;
		if(cost<=2000)
		{
			total=cost*40/100;
		}
		else if(cost>3000)
		{
			total=cost*35/100;
		}
		
		else
			total=cost*30/100;
	
		return total;
			
	}
	
	public int companyRent(int dice)
	{
		int total=dice*4;
		return total;	
	}

	public int stationRent(Player player, int station_size)
	{
		int total=25*station_size;
		return total;
	}
	
	/**
	 * control function is that command input control
	 * @param land_id
	 * @param land_name
	 * @param land_cost
	 * @param station_id
	 * @param station_name
	 * @param station_cost
	 * @param company_id
	 * @param company_name
	 * @param company_cost
	 * @param list
	 * @param list2
	 * @param temp3
	 * @param temp4
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param bw
	 * @throws IOException
	 */
	public void control(ArrayList <String> land_id,ArrayList <String> land_name,ArrayList <String> land_cost,
			ArrayList <String> station_id,ArrayList <String> station_name,ArrayList <String> station_cost,
			ArrayList <String> company_id,ArrayList <String> company_name,ArrayList <String> company_cost,
			ArrayList <String> list,ArrayList <String> list2,ArrayList <String> temp3,
			ArrayList <String> temp4,Player player1,Player player2,Banker banker,BufferedWriter bw) throws IOException
	{
		int control=0;
		int control2=0;
		int control3=0;
		int control4=0;
		int ii=0;
		int jj=0;
		if(control3!=1){
		for(int i=0; i<temp3.size();i++)
		{
			if(player1.getMoney()<=0 || player2.getMoney()<=0){
				show(player1,player2,banker,bw);
				control3=1;
				
			}
			
			if(temp3.get(i).equals("Player 1")){
				cardControl(player1,player1,player2,"Player 1",banker,control,control2,list,list2,land_id,land_name,
						land_cost,station_id,station_name,station_cost,company_id,company_name,company_cost,temp3,temp4,ii,jj,bw);
						control2++;
			}
			
			else if(temp3.get(i).equals("Player 2")){
				cardControl(player2,player1,player2,"Player 2",banker,control,control4,list,list2,land_id,land_name,
						land_cost,station_id,station_name,station_cost,company_id,company_name,company_cost,temp3,temp4,ii,jj,bw);
				control4++;
			}
			
			else
				show(player1,player2,banker,bw);
			
			control++;
			
				
			
		}
		show(player1,player2,banker,bw);
		
		
		}
		
	}
	/**
	 * card control special or normal card
	 * @param player
	 * @param player1
	 * @param player2
	 * @param player_name
	 * @param banker
	 * @param control
	 * @param number
	 * @param list
	 * @param list2
	 * @param land_id
	 * @param land_name
	 * @param land_cost
	 * @param station_id
	 * @param station_name
	 * @param station_cost
	 * @param company_id
	 * @param company_name
	 * @param company_cost
	 * @param temp3
	 * @param temp4
	 * @param i
	 * @param j
	 * @param bw
	 * @throws IOException
	 */
	public void cardControl(Player player,Player player1,Player player2,
			String player_name,Banker banker,int control,int number,ArrayList <String> list,ArrayList <String> list2,
			ArrayList <String> land_id,ArrayList <String> land_name,ArrayList <String> land_cost,
			ArrayList <String> station_id,ArrayList <String> station_name,ArrayList <String> station_cost,
			ArrayList <String> company_id,ArrayList <String> company_name,ArrayList <String> company_cost,
			ArrayList <String> temp3,ArrayList <String> temp4,int i,int j,BufferedWriter bw) throws IOException
			
	{
		int k=0;
		int check=0;
		int control2=0;
		int temp=0;
		player.setDice(Integer.parseInt(temp4.get(control)));
		if(player.getPunish()==0){
		if(number==0){
			player.setPosition(player.getPosition()+Integer.parseInt(temp4.get(control))+1);
			
		}
		else
			player.setPosition(player.getPosition()+Integer.parseInt(temp4.get(control)));
		
			if(player.getPosition()>=40){
				player.setMoney(player.getMoney()+200);
				banker.setMoney(banker.getMoney()-200);
			}
			player.setPosition(player.getPosition()%40);
			
	
		
		for(int l=0;l<land_id.size();l++){
			if((player.getPosition()==Integer.parseInt(land_id.get(l))))
			{	
			
				control2++;
				check=1;
			
				
				ownedControl2(player,player1,player2,player_name,player.getPosition(),"landRent",
						control,temp4,banker,land_name,land_cost,station_name,station_cost,company_name,company_cost,l,bw);
			}
		}
		if(control2==0){
		for(int l=0;l<station_id.size();l++){
			
			
			if(player.getPosition()==Integer.parseInt(station_id.get(l)))
			{

				check=1;
				
				
				ownedControl2(player,player1,player2,player_name,player.getPosition(),"stationRent",
					control,temp4,banker,land_name,land_cost,station_name,station_cost,company_name,company_cost,l,bw);
			}
		}
		}
		if(control2==0){
		for(int l=0;l<company_id.size();l++){
			
			if(player.getPosition()==Integer.parseInt(company_id.get(l)))
			{	
				check=1;
			
				
				
				ownedControl2(player,player1,player2,player_name,player.getPosition(),"companyRent",
				control,temp4,banker,land_name,land_cost,station_name,station_cost,company_name,company_cost,l,bw);
			}
		}
		}
		if(check!=1)
			specialCards(player,player1,player2,player.getPosition(),list,list2,banker,player_name,bw);
	
		
			k++;
			control++;
			
		}
		else{
			
			
			player.setPunish(player.getPunish()-1);
			int count=3-player.getPunish();
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+"in jail(count="+count+")");
			bw.newLine();
		}	
			
			
			
		
	}
	/**
	 * show method
	 * @param player1
	 * @param player2
	 * @param banker
	 * @param bw
	 * @throws IOException
	 */
	public void show(Player player1, Player player2,Banker banker,BufferedWriter bw) throws IOException
	{
		bw.write(player1.getName()+ "\t"+ player1.getMoney());
		bw.newLine();
		bw.write(player2.getName()+ "\t"+player2.getMoney());
		bw.newLine();
		bw.write(banker.getName()+" "+banker.getMoney());
		bw.newLine();
		if(player1.getMoney()<player2.getMoney()){
			bw.write("Winner"+" "+player2.getName());
		bw.newLine();
		}
		else{
			bw.write("Winner"+ " "+player1.getName());
			bw.newLine();
		}
		bw.write("-----------------------------------------------------------------------------------------------------------");
		bw.newLine();
			
			
		
	}
	/**
	 * special cards control
	 * @param player
	 * @param player1
	 * @param player2
	 * @param id
	 * @param list
	 * @param list2
	 * @param banker
	 * @param player_name
	 * @param bw
	 * @return
	 * @throws IOException
	 */
	public int specialCards(Player player,Player player1,Player player2,int id,ArrayList <String> list,ArrayList <String> list2,Banker banker,
			String player_name,BufferedWriter bw) throws IOException
	{
		int result=1;
		
		
		if(id==1)
		{
			player.setMoney(player.getMoney()+200);
			banker.setMoney(banker.getMoney()-200);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+"Go");
			bw.newLine();
		}
		
		else if(id==3)
		{
			final2=final2%list2.size();
			controlChest(list2.get(final2),player,player1,player2,banker,final2,player_name,bw);
			final2++;
			
		}
		
		else if(id==5)
		{
			banker.setMoney(banker.getMoney()+100);
			player.setMoney(player.getMoney()-100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
		    player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+"paid Tax");
			bw.newLine();
		}
		
		else if(id==8)
		{
           final3=final3%list.size();
           controlChance(list.get(final3),player,player1,player2,banker,final3,player_name,bw);
           final3++;
		}
		
		else if(id==11)
		{
			player.setPunish(3);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" went to jail");
			bw.newLine();			
		}
		
		else if(id==18)
		{
			final2=final2%list2.size();
			controlChest(list2.get(final2),player,player1,player2,banker,final2,player_name,bw);
			final2++;
			
		}
		else if(id==21)
		{
			player.setPunish(1);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" is in Free Parking");
			bw.newLine();
		}
		
		else if(id==23)
		{
			final3=final3%list.size();
	        controlChance(list.get(final3),player,player1,player2,banker,final3,player_name,bw);
	        final3++;	
		}
		else if(id==31)
		{
			player.setPosition(11);
			specialCards(player,player1,player2,player.getPosition(),list,list2,banker,player_name,bw);
		}
		
		else if(id==34)
		{
			final2=final2%list2.size();
			controlChest(list2.get(final2),player,player1,player2,banker,final2,player_name,bw);
			final2++;
		}
		
		else if(id==37)
		{
			final3=final3%list.size();
	        controlChance(list.get(final3),player,player1,player2,banker,final3,player_name,bw);
	        final3++;
		}
		else if(id==39)
		{
			banker.setMoney(banker.getMoney()+100);
			player.setMoney(player.getMoney()-100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+"Super Tax");
			bw.newLine();
		}
		else
			result=0;
		
		return result;
		
	}
	
	public void controlChest(String place_name,Player player,Player player1,Player player2,Banker banker,int i,String player_name,BufferedWriter bw) throws IOException
	{
		if(i==0){
			player.setPosition(1);
			player.setMoney(player.getMoney()+200);
			banker.setMoney(banker.getMoney()-200);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==1)
		{
			player.setMoney(player.getMoney()+75);
			banker.setMoney(banker.getMoney()-75);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
			
		}
		else if(i==2)
		{
			player.setMoney(player.getMoney()-50);
			banker.setMoney(banker.getMoney()+50);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();	
		}
		else if(i==3)
		{
			if(player_name.equals("Player 1"))
			{
				player1.setMoney(player1.getMoney()+10);
				player2.setMoney(player2.getMoney()-10);
			}
			else{
				player2.setMoney(player2.getMoney()+10);
			    player1.setMoney(player2.getMoney()-10);
			}
			    bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
						player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			    bw.newLine();
		}
		else if(i==4)
		{
			if(player_name.equals("Player 1"))
			{
				player1.setMoney(player1.getMoney()+50);
				player2.setMoney(player2.getMoney()-50);
			}
			else{
				player2.setMoney(player2.getMoney()+50);
			    player1.setMoney(player2.getMoney()-50);
				}
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==5)
		{
			player.setPosition(5);
			player.setMoney(player.getMoney()+20);
			banker.setMoney(banker.getMoney()-20);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
			
		}
		else if(i==6)
		{
			player.setMoney(player.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==7)
		{
			player.setMoney(player.getMoney()-100);
			banker.setMoney(banker.getMoney()+100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==8)
		{
			player.setMoney(player.getMoney()-50);
			banker.setMoney(banker.getMoney()+50);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==9)
		{
			player.setMoney(player.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(i==10)
		{
			player.setMoney(player.getMoney()+50);
			banker.setMoney(banker.getMoney()-50);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		
	}
	
	public void controlChance(String place_name,Player player,Player player1,Player player2,Banker banker,int j,String player_name,BufferedWriter bw) throws IOException
	{
		if(j==0){
			player.setPosition(1);
			player.setMoney(player.getMoney()+200);
			banker.setMoney(banker.getMoney()-200);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(j==1)
		{
			player.setPosition(27);
			ownedControl(player,player1,player2,player_name,27,banker,bw);
			
			
		}
		else if(j==2)
		{
			player.setPosition(player.getPosition()-3);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(j==3)
		{
			player.setMoney(player.getMoney()-15);
			banker.setMoney(banker.getMoney()+15);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(j==4)
		{
			player.setMoney(player.getMoney()+150);
			banker.setMoney(banker.getMoney()-150);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		else if(j==5)
		{
			player.setMoney(player.getMoney()+100);
			banker.setMoney(banker.getMoney()-100);
			bw.write(player.getName()+"\t"+player.getDice()+"\t"+player.getPosition()+"\t"+
					player1.getMoney()+"\t"+player2.getMoney()+"\t"+player.getName()+" "+place_name);
			bw.newLine();
		}
		
		
	}
	
	public void ownedControl(Player player,Player player1,Player player2,String player_name,int id,Banker banker,BufferedWriter bw) throws IOException
	{
		
		
		
		if(player_name.equals("Player 1"))
		{
			int result=0;
			
			for (int j=0;j<player2.owned.length;j++)
			{
				 if(player2.owned[j]==id)
				{
					player2.setMoney(player2.getMoney()+(2600*30/100));
					player1.setMoney(player1.getMoney()-(2600*30/100));
				}
				 bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
							+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 draw Advance to Leicester Square Player 2 paid rent for Leicester Square");
				 bw.newLine();
				 result=1;
				
			}
			if(result!=1)
			{
			
			for(int i=0;i<player.owned.length;i++)
			{
				if(player.owned[i]==id)
				{
					
				}
				
				else
					player1.owned[player1.owned.length]=id;
			}
			}
		}
		
		else if(player_name.equals("Player 2"))
		{
			int result=0;
			int result2=0;
			
			for (int j=0;j<player1.owned.length;j++)
			{
				 if(player1.owned[j]==id)
				{
					    player2.setMoney(player2.getMoney()-(2600*30/100));
						player1.setMoney(player1.getMoney()+(2600*30/100));
					
					 bw.write(player2.getName()+"\t"+player2.getDice()+"\t"+player2.getPosition()
								+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 2 draw  Player 2 paid rent for Leicester Square");
					 bw.newLine();
					 result=1;
				} 
				
			}
			if(result!=1)
			{
			
			for(int i=0;i<player.owned.length;i++)
			{
				if(player.owned[i]==id)
				{
					bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
							+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 has Leicester Square");
					bw.newLine();
					result2=1;
				}
				
				
			}
			if(result2!=1)
			{
				player.setMoney(player.getMoney()-2600);
				banker.setMoney(banker.getMoney()+2600);
				bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
						+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 bought Leicester Square");
				bw.newLine();
			}
				
			
			}
		}
		
		
		
	}
	/**
	 * place owned control
	 * @param player
	 * @param player1
	 * @param player2
	 * @param player_name
	 * @param id
	 * @param place_name
	 * @param kk
	 * @param temp4
	 * @param banker
	 * @param land_name
	 * @param land_cost
	 * @param station_name
	 * @param station_cost
	 * @param company_name
	 * @param company_cost
	 * @param find
	 * @param bw
	 * @throws IOException
	 */
	public void ownedControl2(Player player,Player player1,Player player2,String player_name,int id,
			String place_name,int kk,ArrayList<String>temp4,Banker banker,ArrayList<String>land_name,
			ArrayList<String>land_cost,ArrayList<String>station_name,ArrayList<String>station_cost,
			ArrayList<String>company_name,ArrayList<String>company_cost,int find,BufferedWriter bw) throws IOException
	{
		int cost=0;
		
		
		
		if(player_name.equals("Player 1"))
		{
			int result=0;
			int result2=0;
			
			for (int j=0;j<player2.owned.length;j++)
			{
				 if(player2.owned[j]==id)
				{
					if(place_name.equals("landRent")){
						cost=landRent(player,Integer.parseInt(land_cost.get(player.getPosition())));
						player2.setMoney(player2.getMoney()+cost);
						player1.setMoney(player1.getMoney()-cost);
						bw.write(player1.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
								+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+land_name.get(find));
						bw.newLine();
					}
					else if(place_name.equals("stationRent")){
						cost=stationRent(player,Integer.parseInt(station_cost.get(player.getPosition())));
						player2.setMoney(player2.getMoney()+cost);
						player1.setMoney(player1.getMoney()-cost);
						bw.write(player1.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
								+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+station_name.get(find));
						bw.newLine();
					}
					if(place_name.equals("companyRent")){
						cost=companyRent(player.owned.length);
						player2.setMoney(player2.getMoney()+cost);
						player1.setMoney(player1.getMoney()-cost);
						bw.write(player1.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
								+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+company_name.get(find));
						bw.newLine();
					}
						
					
					result=1;
					
				}
				
				
			}
			if(result!=1)
			{
			
			for(int i=0;i<player.owned.length;i++)
			{
				if(player.owned[i]==id)
				{
					bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
							+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 has"+" "+land_name.get(find));
					bw.newLine();
					result2=1;
				}
				
				
			}
			if(result2!=1)
			{
				for(int l=0;l<player1.owned.length;l++)
				{
					if(player1.owned[l]==0)
					{
						player1.owned[l]=id;
						if(place_name.equals("landRent"))
						{
				
							player1.setMoney(player1.getMoney()-Integer.parseInt(land_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(land_cost.get(find)));
							bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 bought"+" "+land_name.get(find));
							bw.newLine();
						}
						
						else if(place_name.equals("stationRent"))
						{
							player1.setMoney(player1.getMoney()-Integer.parseInt(station_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(station_cost.get(find)));
							bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 bought"+" "+station_name.get(find));
							bw.newLine();
						}
						
						else if(place_name.equals("companyRent"))
						{
							player1.setMoney(player1.getMoney()-Integer.parseInt(company_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(company_cost.get(find)));
							bw.write(player1.getName()+"\t"+player1.getDice()+"\t"+player1.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 1 bought"+" "+company_name.get(find));
							bw.newLine();
						}
					

				break;
					}
				
				}
			}
		}	
	}
		
		else if(player_name.equals("Player 2"))		{
			
			int result=0;
			int result2=0;
			
			for (int j=0;j<player1.owned.length;j++)
			{
				 if(player1.owned[j]==id)
				{
		   		    if(place_name.equals("landRent")){
						cost=landRent(player,Integer.parseInt(land_cost.get(find)));
						player2.setMoney(player2.getMoney()-cost);
						player1.setMoney(player1.getMoney()+cost);
						bw.write(player2.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
								+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+land_name.get(find));
						bw.newLine();
		   		    }
					else if(place_name.equals("stationRent")){
						cost=stationRent(player,Integer.parseInt(station_cost.get(find)));
						player2.setMoney(player2.getMoney()-cost);
						player1.setMoney(player1.getMoney()+cost);
						bw.write(player2.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
								+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+station_name.get(find));
						bw.newLine();
					}	
					else if(place_name.equals("companyRent")){
							cost=companyRent(player.owned.length);
							player2.setMoney(player2.getMoney()-cost);
							player1.setMoney(player1.getMoney()+cost);
							bw.write(player2.getName()+"\t"+player.getDice()+"\t"+player.getPosition()
									+"\t"+player1.getMoney()+"\t"+player2.getMoney()+"\t"+"Player 2 paid rent for"+" "+station_name.get(find));
							bw.newLine();
							
					player1.setMoney(player1.getMoney()+cost);
					player2.setMoney(player2.getMoney()-cost);
						
				}
		   		 result=1;
				} 
				
			}
			if(result!=1)
			{
			
			for(int i=0;i<player.owned.length;i++)
			{
				if(player.owned[i]==id)
				{
					bw.write(player2.getName()+"\t"+player2.getDice()+"\t"+player2.getPosition()
							+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 2 has"+" "+land_name.get(find));
					bw.newLine();
					result2=1;
				}
				
				
			}
			if(result2!=1)
			{
				for(int l=0;l<player1.owned.length;l++)
				{
					if(player2.owned[l]==0)
					{
						player2.owned[l]=id;
						if(place_name.equals("landRent"))
						{
				
							player2.setMoney(player2.getMoney()-Integer.parseInt(land_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(land_cost.get(find)));
							bw.write(player2.getName()+"\t"+player2.getDice()+"\t"+player2.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 2 bought"+" "+land_name.get(find));
							bw.newLine();
						}
						
						else if(place_name.equals("stationRent"))
						{
							player2.setMoney(player2.getMoney()-Integer.parseInt(station_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(station_cost.get(find)));
							bw.write(player2.getName()+"\t"+player2.getDice()+"\t"+player2.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 2 bought"+" "+station_name.get(find));
							bw.newLine();
						}
						
						else if(place_name.equals("companyRent"))
						{
							player2.setMoney(player2.getMoney()-Integer.parseInt(company_cost.get(find)));
							banker.setMoney(banker.getMoney()+Integer.parseInt(company_cost.get(find)));
							bw.write(player2.getName()+"\t"+player2.getDice()+"\t"+player2.getPosition()
									+"\t"+player1.getMoney()+"\t"+ player2.getMoney()+"\t"+"Player 2 bought"+" "+company_name.get(find));
							bw.newLine();
						}

				
				break;
					}
				
				}
			}
		}	
		}
	}
		
	
	
	
		
}