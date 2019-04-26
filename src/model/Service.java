package model;


public class Service {



public static final String PET_BATHV="Pet bath in the veterinary";
public final static String PET_BATHD="Pet bath at home";
public static final String NAIL_CUTTING="Nail cutting";
public final static String DENTA_PRO="Dental prophylaxis";
public static final String VACCINATIONS="Vacine";


//atributes 

private String type;
private double cost;
private String idPet;
private String idOwner;

//relations
private Date realization;
private Mascot theMascot;



/**
name:Costructor Service 
 @param type the type of the service 
 @param realization the realization  of the service
 @param theMascot   theMascot  the Mascot to whom the service was performed
*/
public Service(String type,Date realization,Mascot theMascot){
	this.type=type;
	this.realization=realization;
	this.theMascot=theMascot;
	idPet=theMascot.getNamePet();
	cost=costService();
	idOwner=theMascot.idOwerr();

}

/**
  Gets the Service type
  @return type of service 
*/
public String  getType(){
	return type;
}

/**
  Sets the service type
  @param type type of service 
*/
public void setType(String type){
	this.type=type;

}
/**
  Gets the cost
  @return cost 
*/
public double getCost(){
	return cost;

}


/**
 Sets the cost
 @param cost the cost 
*/
public void setCost(double cost){
	this.cost=cost;
}
/**
 Gets the Identifier pet 
 @return idPet the idPet
*/

public String getIdPet(){
	return idPet;
}


/**
 Sets the identifier pet
 @param idPet the identifier pet 
*/
public void setIdPet(String idPet){
	this.idPet=idPet;
}

/**
 Gets the Identifier Owner 
  @return idOwner the identifier idOwner 
*/
public String getIdOwner(){
	return idOwner;
}
 /**
  Sets the identifier Owner 
  @param idOwner the identifier owner 
 */
public void setIdOwner(String idOwner){
	this.idOwner=idOwner;
}
 /**
  Gets the Date Realization Service 
  @return realization of the service 
 */


public Date getRealization(){
	return realization;
}
/**
  Sets Date the Realization service
  @param realization realization of the service 
*/
public void setRealization(Date realization){
	this.realization=realization;
}

/**
 Gets the Mascot
 @return the mascost
*/
public Mascot getTheMascot(){
	return theMascot;
}

/**
 Sets the mascost
 @param theMascot the mascot 
*/

public void setTheMascot(Mascot theMascot){
	this.theMascot=theMascot;
}
/**
  Calculates the cost of the service<br>
  pre: the service was created before and the type must be not null<br>
  post: the cost is calculated<br> 
  @return the cost of the type service 
*/

public double costService(){

    double theCost=0.0;


    if (type.equals(PET_BATHV)){
    	theCost=20000.0;

    }
    else if (type.equals(PET_BATHD)){
    	theCost=30000.0;
    }
    else if (type.equals(NAIL_CUTTING)){
    	theCost=8000.0;
    }
    else if (type.equals(DENTA_PRO)){
    	theCost=12000.0;

    }
    else if (type.equals(VACCINATIONS)){
    	theCost=45000.0;
    }
return theCost;


}










}