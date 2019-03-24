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


public String showRoomInformation(){
	String msj ="";

	msj +="````````````````````````````````````````````````````````\n";
	msj += "Si esta ocupado :\n 1. True Y si no esta ocupado 2. False: "+""+availability+"\n";
    msj += "El numero del mini cuarto es :"+numMiniroom+"\n";
    msj +="````````````````````````````````````````````````````````\n";
return msj;
}

}