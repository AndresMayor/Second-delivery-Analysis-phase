package model;
import java.util.ArrayList;

public class Veterinary{


//Relations 


private Miniroom[] rooms;
private ArrayList<ClinicHistory> histories;
private ArrayList<HumanClient> clients;


//Constructor 


public Veterinary(){

	rooms = new Miniroom[8];
	histories = new ArrayList<ClinicHistory>();
	clients = new ArrayList<HumanClient>();



}

//Get s And Set s
public Miniroom[] getRooms(){
	return rooms;
}
public void setRooms(Miniroom[] rooms){
	this.rooms=rooms;
}



public ArrayList<ClinicHistory> getHistories (){
	return histories;
}

public void setHistories(ArrayList<ClinicHistory> histories){
	this.histories= histories;
}



public ArrayList<HumanClient> getClients(){
	return clients;
}
public void setClients(ArrayList<HumanClient> clients){
	this.clients=clients;
}




public void addHistorys(ClinicHistory history1){
    histories.add(history1);
}


public void addClients(HumanClient client1){
		clients.add(client1);
}

public boolean findCustomer(String iD){
		boolean foundClient= false;
		for(int i = 0; !foundClient && i < clients.size(); i++){
			if(iD.equals(clients.get(i).getID())){
				foundClient = true;
				}
		}
		return foundClient;
}
public String namesMascots(String iD){
		String message = "";
		boolean foundClient = false;
		if(findCustomer(iD) == true){
			for(int i = 0; !foundClient && i < clients.size(); i++){
				if(iD.equals(clients.get(i).getID())){
					message = clients.get(i).nameMascots();
					foundClient = true;
				}
			}
		}
		return message;
}


}