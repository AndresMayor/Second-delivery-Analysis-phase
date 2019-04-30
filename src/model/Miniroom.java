package model;
/**
*this class contains the information of the mini roms
*/
public class Miniroom{

//Atributes 


	private boolean availability;
	private int numMiniroom;
    

//Relations 


public  ClinicHistory history;


/**
*MiniRoom constructor
*@param availability the occupied status of the mini room
*@param numberMiniroom the number of the mini room
*@param history the clinic history of the pet hospitalized
*/
public Miniroom(boolean availability, int numMiniroom,ClinicHistory history){

this.availability=availability;
this.numMiniroom=numMiniroom;
this.history=history;

}




/**
*Gets the availability
*@return the availability status of the room
*/
public boolean getAvailability(){
	return availability;
}

/**
*Sets the availability
*@param availability the availability status of the mini room
*/
public void setAvailability(boolean availability){
	this.availability=availability;
}

/**
*Gets the clinic history
*@return the clinic history of the pet hospitalized
*/
public ClinicHistory getHistory(){
	return history;
}

/**
*Sets the clinic history
*@param history the clinic history of the pet hospitalized
*/
public void setHistory(ClinicHistory history){
	this.history=history;
}

/**
*Gets the number of the mini room
*@return the number of the mini room
*/


public int getNumMiniroom(){
	return numMiniroom;
}

/**
*Sets the number
*@param numberMiniroom the number of the mini room
*/
public void setNumberMiniroom(int numMiniroom){
	this.numMiniroom = numMiniroom;
}

/**
*to get the cost of the hospitalization<br>
*pre: the availability is false and the history must be not null<br>
*post: the cost of the hospitalization is calculated<br>
*@return the cost of the hospitalization
*/
public double hospitalizeCost(){
	return history.hospitalizationCost();
}

/**
*To return the report of the clinic history<br>
*pre: the availability is false and the history must be not null<br>
*post: the report is generated<br>
*@return the report of the clinic history of the pet hospitalized
*/
public String showRoomInformation(){
	String msj ="";

	msj +="````````````````````````````````````````````````````````\n";
	msj += "Si esta ocupado :\n 1. True Y si no esta ocupado 2. False: "+""+availability+"\n";
    msj += "El numero del mini cuarto es :"+numMiniroom+"\n";
    msj +="````````````````````````````````````````````````````````\n";
return msj;
}

public String drugHistry(String name, double dose, double costDose, double frecuency){
  String msg="";
 msg=history.addDrug(name,  dose,  costDose, frecuency);
  return msg;

}


public void addNotesToPet(String notes){

  history.addNotesToHospitalizationFatality(notes);
}


}

