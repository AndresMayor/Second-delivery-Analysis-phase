package model;
/**
*This class contains the information of the medicines
*/
public class Medicine{

//Atributes

	private String name;
	private double dose;
	private double costDose;
	private double frecuency;



/**
*Medicine constructor
*@param name the name of the medicine. This param must be not null.
*@param dose the dose of the medicine for the patient. This param must be not null.
*@param costDose the cost of each dose
*@param frequency the frequency of the medicine
*/
public Medicine(String name, double dose, double costDose, double frecuency){

  this.name=name;
  this.dose=dose;
  this.costDose=costDose;
  this.frecuency=frecuency;

}

/**
*Gets the name
*@return the name of the drugs
*/
public String getName(){
	return name;
}
/**
*Sets the name
*@param name the name. This param must be not null.
*/
public void setName(String name ){
	this.name=name;

}

/**
*Gets the dose
*@return the dose of the drugs
*/
public double getDose(){
	return dose;

}
/**
*Sets the dose
*@param dose the dose of the drug. This param must be not null.
*/
public void setDose(double dose ){
	this.dose=dose;
}
/**
*Gets the cost of each dose
*@return the cost of each dose
*/
public double getCostDose(){
	return costDose;
}
/**
*Sets the cost of each dose
*@param costDose the cost of each dose
*/
public void setCostDose(double costDose){
	this.costDose=costDose;
}

/**
*Gets the frequency
*@return the frequency
*/
public double getFrecuency(){
	return frecuency;
}

/**
*Sets the frequency
*@param frequency the frequency
*/
public void setFrecuency(double frecuency){
	this.frecuency=frecuency;
}
/**
*This method calculates the cost of the drugs<br>
*pre: The drug was created before and its attributes dose and costDose must be not null.<br>
*post: The cost is calculated.<br>
*@return the cost of the medicine
*/
public double calculatedDose(){
double totalCost = 0.0;

totalCost += dose * costDose;

return totalCost;



}

}