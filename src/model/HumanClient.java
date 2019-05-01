package model;

import java.util.ArrayList;
/**
*In this class you will find information for clients
*/
public class HumanClient{


//Atributes


	private String name;
	private String iD;
	private String address;
	private String telePhone;


//Relations

	private ArrayList<Mascot> mascots;

/**
*HumanClient constructor
*@param name the name
*@param iD the identifier
*@param address the address
*@param telePhone the phone number
*/
	public HumanClient(String name,String iD,String address,String telePhone){
		this.name=name;
		this.iD=iD;
		this.address=address;
		this.telePhone=telePhone;
		mascots = new ArrayList<Mascot>();
	}



/**
*Gets the name
*@return the name
*/

    public String getName(){
	   return name;
    }

/**
*Sets the name 
*@param name the name 
*/
	public void setName(String name){
		this.name=name;
	}
/**
 *Gets the iD
 *@return the iD
 */
	public String getID(){
		return iD;
	}
/**
*Sets the identifier
*@param iD the identifier
*/
	public void setID(String iD){
		this.iD=iD;
	}
/**
*Gets the address
*@return the address
*/
	public String getAddress(){
		return address;
	}
/**
*Sets the address
*@param address the address
*/
	public void setAddress(String address){
		this.address=address;
	}

/**
*Gets the phone number
*@return the phone number
*/
	public String getTelePhone(){
		return telePhone;
	}
/**
*Sets the phone number
*@param telePhone the phone number
*/
	public void setTelePhone(String telePhone){
		this.telePhone=telePhone;
	}
/**
*Gets the Mascots
*@return the Mascots
*/
	public ArrayList<Mascot> getMascots(){
		return mascots;
	}
/**
*Sets the mascots
*@param mascots the mascots
*/
	public void setMascots(ArrayList<Mascot> mascots){
		this.mascots=mascots;

	}
/**
*to add a pet<br>
*pre: The human client was created before and the pet is initialized<br>
*post: The new pet were added to the human client<br>
*@param mascots1 the pet to add
*/
	public void addMascots(Mascot  mascots1){
		mascots.add(mascots1);
	}

/**
*to return the name of the mascots that the client has<br>
*pre: The human client was created before and mascot is initialized<br>
*post: the names of the mascots is delivered<br>
*@return the name of the mascots 
*/
	public String nameMascots(){
		String msg = "";
		int position = 1;
		for(int i = 0; i < mascots.size(); i++){
			msg += position+". "+mascots.get(i).getNamePet()+"\n";
			position++;
		}
		return msg;
	}




public Mascot findPet(String nampe){

	Mascot andy = null;
	boolean found = false;

	for(int i = 0; i<mascots.size() && !found; i++){

		if(mascots.get(i).getNamePet().equals(nampe)){
			andy = mascots.get(i);
			found = true;
		}

	}

	return andy;
}

/**
*to return the contact details
*@return the contact details of the human client
*/
public String infoClient(){
String msj = "";
msj += "+--------------------------------------------------------------+\n";
msj += "| Customer name: " + name + "\n";
msj += "| iD of the Client: " + iD+ "\n";
msj += "| Residence address: " + address + "\n";
msj += "| Contact number: " + telePhone + "\n";
msj += "+--------------------------------------------------------------+\n";

int j = 0;
for(int i = 0; i<mascots.size(); i++){
	++j;
msj += "Pet"+ j + "";
msj += mascots.get(i).showInfoPet();
}
return msj;
}


/**
*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
*pre: The client was created before.
*post: The address and /or phone number of the client is updated.
*@param address The new address of the client. This param could be empty.
*@param phoneNumber The new phone number of the client. This param could be empty.
*/
	public void modificDatas(String address, String telePhone){
		this.address = address;
		this.telePhone=telePhone;
	}

}

