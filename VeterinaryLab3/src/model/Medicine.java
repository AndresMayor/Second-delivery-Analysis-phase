package model;

public class Medicine{

//Atrinutos

	private String name;
	private double dose;
	private double costDose;
	private double frecuency;



//Metodo Constructor 


public Medicine(String name, double dose, double costDose, double frecuency){

  this.name=name;
  this.dose=dose;
  this.costDose=costDose;
  this.frecuency=frecuency;

}

//get and set


public String getName(){
	return name;
}

public void setName(String name ){
	this.name=name;

}

public double setDose(){
	return dose;

}
public void setDose(double dose ){
	this.dose=dose;
}

public double getCostDose(){
	return costDose;
}
public void setCostDose(double costDose){
	this.costDose=costDose;
}

public double setFrecuency(){
	return frecuency;
}

public void setFrecuency(double frecuency){
	this.frecuency=frecuency;
}
public double calculatedDose(){
double totalCost = 0.0;

totalCost += dose * costDose;

return totalCost;



}

}