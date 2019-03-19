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





}