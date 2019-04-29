package model;
import java.util.ArrayList;

public class Mascot{

//Atrinutos 
    private String name;
    public   static final char CAT = 'G';
    public final static char DOG = 'P';
    public  static final char BIRD = 'A';
    public  final static char  OTHER= 'O';
    private double weight;
    private int age;
    private char type;
    private double height;
    private double imc;


//Relations

    private HumanClient owner;

//Metodo Constructor



/**
	*Mascot constructor
	*@param name the Mascot name
	*@param weight the Mascot weight
	*@param age the Mascot age
    *@param type the Mascot type
	*@param owner the owner of the animal. This param must be not null
	*/

public Mascot(String name,double weight,int age,char type,HumanClient owner,double height){
	this.name=name;
	this.weight=weight;
	this.age=age;
	this.type=type;
	this.owner=owner;
	this.height=height;
	imc=calculateIMC();


    

}


/**
	*Gets the namePet
	*@return the Mascot name
*/

public String getNamePet(){
	return name;


}

/**
 *Sets the namePet 
 @param name the mascot name 
*/
public void setNamePet(String name){
	this.name=name;
}


/**
  *Gets the Weight
  *@return the mascot weight
*/

public double getWeight(){
	return weight;
}

/**
  *Sets the weight
  *@param weight the mascot weight
*/
public void setWeight(double weight){
	this.weight=weight;
}

/**
 *Gets the age 
 *@return the mascot age 
*/

public int getAge(){
	return age;
}

/**
 *Sets the mascot age 
 *@param age the mascot age 
*/
public void setAge(int age){
	this.age=age;
}

/**
  *Gets the mascot type
  *@return the mascot type 
*/
public char getType(){
	return type;
}

/**
  *Sets the mascots type 
  *@param type the mascot type
*/
public void setType(char type){
	this.type=type;
}

/**
  *Gets the mascot owner 
  *@return the mascot owner
*/
public HumanClient getOwner(){
	return owner;
}
/**
 *Sets the  owner
 *@param owner the mascot owner
*/
public void setOwner(HumanClient owner){
	this.owner=owner;
}

/**
    metod :idOwnerr
	*to return the identifier of the owner<br>
	*pre: The mascot  was created before and the owner must be not null<br>
	*post: the owner's identifier is delivered<br>
	*@return the ID of the owner
	*/
public String idOwerr(){
	return owner.getID();
}




public String showInfoPet(){
 String msj = "";
 msj += "`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\n";
 msj += "Nombre : " + name + "\n";
 msj += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
 msj += "Edad : " + age + "\n";
 msj += "`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\n";
 msj += "Peso: " + weight + "\n";
 msj += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
 msj +="Tipo de Mascota: " + type + "\n";
 msj += "`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\n";
 msj += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
 msj +="El imc de la mascota es : " + calculateIMC() + "\n";
 msj += "`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\n";

	return msj;


}



/**
*Description This method allows to calculate the body mass index for a pet.
*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
*post: The BMI is calculated.
*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
*/

public double calculateIMC(){

	return weight/(height * height);
	}











}


