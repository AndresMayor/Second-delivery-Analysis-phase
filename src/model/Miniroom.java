package model;

public class Miniroom{

//Atributos 


	private boolean availability;
	private int numMiniroom;


//Relations 


private ClinicHistory history;


//Constructor 


public Miniroom(boolean availability, int numMiniroom,ClinicHistory history){

this.availability=availability;
this.numMiniroom=numMiniroom;
this.history=history;

}



//get's and set's

public boolean getAvailability(){
	return availability;
}
public void setAvailability(boolean availability){
	this.availability=availability;
}



public ClinicHistory getHistory(){
	return history;
}
public void setHistory(ClinicHistory history){
	this.history=history;
}



public int getNumMiniroom(){
	return numMiniroom;
}
public void setNumminiRoom(int numMiniroom){
 this.numMiniroom=numMiniroom;
}



}