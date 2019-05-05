/** | Name :Andrés Mayor Aldana    |
    | Algoritmos y Programacion    |
    | Univesidad Icesi             |
    | A00359333                    |
    | Camilo Barrios               |
    | Laboratorio 3                |    
**/
package model;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
*This is the main class in the model, it contains all the information for the veterinary my little pet.
*/
public class Veterinary{

//Relations 

private Miniroom[] rooms;
private ArrayList<ClinicHistory> histories;
private ArrayList<HumanClient> clients;
private ArrayList<Service>services;

/**
*Veterinary constructor
*/
public Veterinary(){

	rooms = new Miniroom[8];
	histories = new ArrayList<ClinicHistory>();
	clients = new ArrayList<HumanClient>();
  services= new ArrayList<Service>();



}


/**
 *Gets the rooms
 *@return the rooms
 */
public Miniroom[] getRooms(){
	return rooms;
}

/**
  *Sets the rooms
  *@param rooms the rooms
  */
public void setRooms(Miniroom[] rooms){
	this.rooms=rooms;
}

/**
*Gets the histories 
*@return the histories of clinic histories 
*/
public ArrayList<ClinicHistory> getHistories (){
	return histories;
}


/**
 *Sets the histories 
 *@param histories the histories 
*/
public void setHistories(ArrayList<ClinicHistory> histories){
	this.histories= histories;
}

/**
*Gets the human client 
*@return the clients  
*/
public ArrayList<HumanClient> getClients(){
	return clients;
}

/**
 *Sets the Clients 
 *@param clients  the human clients  
*/

public void setClients(ArrayList<HumanClient> clients){
	this.clients=clients;
}

/**
  *Gets the services
  *@return services
  */

public ArrayList<Service> getServices(){
  return services;
}

/**
 *Sets the services 
 *@param services the service   
*/
public void setServices(ArrayList<Service> services){
  this.services=services;
}


/**
  *To add new clinic histories to the record
  *@param history1 the new clinic history to add
  */

public void addHistorys(ClinicHistory history1){
    histories.add(history1);
}

/**
  *To add new clients 
  *@param cliente1  the new client
  */
public void addClients(HumanClient client1){
		clients.add(client1);
}


  /**
  *To check if a client is already registered
  *@param iD the identifier of the client
  *@return a boolean indicates if the client is already registered or not
  */
public boolean findCustomer(String iD){
		boolean foundClient= false;
		for(int i = 0; !foundClient && i < clients.size(); i++){
			if(iD.equals(clients.get(i).getID())){
				foundClient = true;
				}
		}
		return foundClient;
}

/**
*This method looks for a client's pets
*@param iD id of the client 
*@return message about customers' pets
*/

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


/**
*The method evaluates if it can be added to the mini room
*pre: the mini rooms can not be null
*@param current Mascot  the pet to compare it
*@return msg Yes message could be added
*/
  public String addPetToAvailableRoom (Mascot current){

    String msg = "";
    boolean found = false;

    for(int i =0; i< rooms.length && !found; i++){

      if(rooms[i].getAvailability()){
        found = true;
        rooms[i].getHistory().setDatas(current);
        rooms[i].setAvailability(false);

        msg = "It was added successfully to "+current.getNamePet()+" in the room" + (i+1);
      }
    }
    if(!found){
      msg = "You can not be hospitalized because you did not find an empty room.";
    }

    return msg;
  }



/**
*This method looks for if you can hospitalize a pet
*pre: customers can not be null
*@param idclient id of teh client 
*@param nameMascot  name of the pet 
*@return message yes you can hospitalize
*/
public String hospitalize(String idclient, String nameMascot){

  String msg = "";
  Mascot andy = null;
  for(int i =0; i<clients.size() && andy==null; i++){
    if(clients.get(i).getID() == idclient){
        andy = clients.get(i).findPet(nameMascot);
        if(andy==null){
          msg = "The client does not have a pet with that name";
        }
    }
  }
 if(andy!=null){
  msg = addPetToAvailableRoom(andy);
 }

  return msg;
}



  /**
  *To return is there is a room available
  *@return a boolean indicates if there is a room available or not
  */

public boolean avaibleRoom(){
boolean f = false;

for(int i = 0; i < rooms.length; i++){
  if(rooms[i].getAvailability()){
   f = true;
 }

}
  return f;
}

/**
*Description This method of Customer information.
*pre: Customers can not be null. 
*@return msj customer information.
*/
public String showClients(){
  String msj = "";
  msj += clients.size();
   for(int i = 0 ; i<clients.size(); i++){
     msj +=  (i+1) + clients.get(i).infoClient();
  }
  return msj;



}
/**
*Description This method discharges a hospitalized pet
*pre: The mini room can not be null
*@param macotsNames name of the mascot
*@return message confirming if the animal was removed
*/

public String darAlta(Mascot mascotsNames){
 boolean recorrido = false;
 String msj = "";
    for(int i = 0; i < rooms.length && !recorrido; i++){
      if(!rooms[i].getAvailability()){
        if(rooms[i].getHistory().getDatas().equals(mascotsNames)){
          rooms[i].getHistory().setDatas(null);
          recorrido= true;
          rooms[i].setAvailability(true);
          msj = "The mascot of the room was removed";
        }
      }
      else{
        msj = "Your hospitalized animal was not found";
      }
    }
    return msj;
  }

/**
*Description evaluate if a pet can be hospitalized
*pre: customers can not be null
*@param idClientt id of the client
*@param nampe name of the pet 
*@return message if you can hospitalize
*/
public String findToHospitalize(String idClientt, String nampe){
  String msg = "";
  Mascot andy = null;
  for(int i =0; i<clients.size() && andy==null; i++){
    if(idClientt .equals(clients.get(i).getID())){
        andy = clients.get(i).findPet(nampe);
        if(andy==null){
          msg = "El cliente no tiene una mascota con ese nombre";
        }
      }
  }
 if(andy != null){
  msg = darAlta(andy);
 }

  return msg;
}

/**
*Description This method of room information
*pre: the rooms can not be null
*@return message about the information of mini rooms
*/

public String showRooms(){
  String msj="";
  for ( int i =0; i <rooms.length;i++){
    msj+=rooms[i].showRoomInformation();
  }
  return msj;
}



/**
*This method hospitalizes a pet
*@param history1 clinic history of the pet 
*/
public void hospitalizeAPet(ClinicHistory history1){
  boolean roomAvailable = false;
    for(int i = 0; !roomAvailable && i < rooms.length; i++){
      if(rooms[i].getAvailability() == true){
        rooms[i].setAvailability(false);
        rooms[i].setHistory(history1);
        roomAvailable = true;
      }
}
}
/**
*to return the client
*@param id the identifier of the client
*@return the client that is wanted
*/

  public HumanClient clint(String id){
    HumanClient client1 = null;
    boolean clienteJ = false;
    if(findCustomer(id) == true){
      for(int i = 0; !clienteJ && i < clients.size(); i++){
        if(id.equals(clients.get(i).getID())){
          client1 = clients.get(i);
          clienteJ = true;
        }
      }
    }
    return client1;
  }

/**
*This method calculates income from services.
*@return cost of the services.
*/

public double ingresService(){

double cost =0.0;

for (int i=0;i<services.size();i++){


  cost+=services.get(i).getCost();
}

return cost;



}

/**
*This method serves to add services.
*@param service1 service.
*/
public void addService(Service service1){
  services.add(service1);
}


//lab4


public HumanClient returnClient(String idClient){
boolean client =false ;
HumanClient client1=null;
  for (int i =0;i<clients.size() && !client ;i++){

     if (findCustomer(idClient)&& clients.get(i).getID().equals(idClient)){

         client1=clients.get(i);
     }
  }
  return client1;
}

/**
*This method calculates ythe average income from services 
*@return The value if the average income from services.
*/
public double promedioIngresService(){

  return ingresService()/services.size();
}

/**
*This method calculates the cost for a hospitalization 
*@return cost of hospitalization
*/
public double costOfHospitalizatee(){
  double temp=0.0;

  for (int i=0;i<histories.size();i++){
    temp+=histories.get(i).hospitalizationCost();
  }
  for (int k=0; k<rooms.length ;k++){
    if(rooms[k].getAvailability()==false){
      temp+=rooms[k].hospitalizeCost();
    } 
  }
  return temp;
}

/**
*This method calculates the total income of the veterinary
*@return total cost of the veterinary
*/
public double ingressTotalsVeter(){
  return promedioIngresService()+costOfHospitalizatee();
}

/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New medicines were added to the patient clinic story.
*@param name  medicine name. This param must be not null.
*@param dose  medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
*@param costDose medicine cost by each dose. This param could be empty.
*@param frecuency  frequency of medicine application. This param could be empty.
*@param number number of the mini room 
*@return A message that indiques if medicine was added to the patient clinic story
*/
public String addMedicine(String name, double dose, double costDose, double frecuency,int  number){
String msg="";
boolean centinela=false ;
  for (int i =0;i<rooms.length && !centinela; i++ ){

    if (number==rooms[i].getNumMiniroom()){
      
       msg=rooms[i].drugHistry( name,  dose, costDose,  frecuency);
       centinela=true;
  }
}
   if (centinela==false){
    msg="The number entered is incorrect. ";
   }
return msg;
}

/**
*this method allows to know the mini occupied rooms
*pre:the mini rooms can not be null
*@return occupied mini-rooms
*/

public String minucuartos(){

String msg="";

for (int i=0;i<rooms.length;i++){
  if (rooms[i].getAvailability()==false){
    msg +=rooms[i].getNumMiniroom()+"\n";
  }
}
  return msg;
}



/**
*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
*pre: The client was created before.
*post: The address and /or phone number of the client is updated.
*@param andress  new address of the client. This param could be empty.
*@param telephone new phone number of the client. This param could be empty.
*@param id iD of the client 
*/
public String modificDatas(String id , String andress,String telephone){
  String msg="The customer data could not be modified";
  boolean centinela=false;

  for (int i=0;i<clients.size() && !centinela ;i++){

    if ( id.equals(clients.get(i).getID()) ){

     clients.get(i).modificDatas(andress, telephone);
      centinela = true;
      

    }
  }

  if (centinela){
    msg="Updated customer data";
  }
return msg ;


}

/**
*this method allows us to calculate the average income for services in a week
*@param n date week
*@return average income in a week
*/




public double calculateFecha(Date n ){

int service=0;
double total=0.0;
int days =0;
int dayss=0;
GregorianCalendar date = new GregorianCalendar(n.getYear(), n.getMonth() - 1, n.getDay());
GregorianCalendar actualDate = new GregorianCalendar(0,0,1);
while (true) {
if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
&& (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
   break;
}
  actualDate.add(Calendar.DAY_OF_MONTH, 1);
   days++;
}
dayss =  days+7;

for (int i=0; i<services.size();i++){
   if(services.get(i).calculateDate()>=days && services.get(i).calculateDate()<= dayss){
       service++;
       total+=services.get(i).costService();
  }
}
return total/service;
}

/**
*this method allows to find the mini room and add the note
*pre: the mini rooms can not be null<br>
*@param clientIdentify id of te client 
*@param nameClientPe  name of the mascot 
*@param notes new notes
*@return the new diagnostics
*/


public String addNotesToHospitalization(String clientIdentify, String nameClientPe, String notes){
String msg ="";
boolean perro = false;

for(int i = 0; i < rooms.length && perro == false; i++){
  if(rooms[i].getHistory()!=null){
      if(rooms[i].getHistory().getDatas().getOwner().getID().equals(clientIdentify) && rooms[i].getHistory().getDatas().getNamePet().equals(nameClientPe)){
         rooms[i].addNotesToPet(notes);
        msg = rooms[i].getHistory().getDiagnosis();
         perro = true;

    }
    }
  }


  return msg;
  }



public String calculateFecha(Date n,Date t ){
String reports="";
int days =0;
int dayss=0;
GregorianCalendar date = new GregorianCalendar(n.getYear(), n.getMonth() - 1, n.getDay());
GregorianCalendar actualDate = new GregorianCalendar(0,0,1);
while (true) {
if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
&& (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
   break;
}
  actualDate.add(Calendar.DAY_OF_MONTH, 1);
   days++;
}

GregorianCalendar inicio = new GregorianCalendar(t.getYear(), t.getMonth() - 1, t.getDay());
GregorianCalendar finall = new GregorianCalendar(0,0,1);
while (true) {
if ((inicio.get(Calendar.DAY_OF_MONTH) == finall.get(Calendar.DAY_OF_MONTH))
&& (inicio.get(Calendar.MONTH) == finall.get(Calendar.MONTH))
&& (inicio.get(Calendar.YEAR) == finall.get(Calendar.YEAR))){
   break;
}
  finall.add(Calendar.DAY_OF_MONTH, 1);
   dayss++;
}


for (int i=0;i<services.size();i++){
  if (services.get(i).calculateDate()>=days && services.get(i).calculateDate()<=dayss){

    reports+=services.get(i).toString();
  }

}
return reports;
}


/**
*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: A new symptom were added to the patient clinic story.
*@param symptoms  new symptom presented. This param must be not null.
*/

public String addSymptoms(String clientIdentify, String nameClientPe, String symptoms){
String msg ="";
boolean perro = false;

for(int i = 0; i < rooms.length && perro == false; i++){
  if(rooms[i].getHistory()!=null){
      if(rooms[i].getHistory().getDatas().getOwner().getID().equals(clientIdentify) && rooms[i].getHistory().getDatas().getNamePet().equals(nameClientPe)){
         rooms[i].addSymptomsToPet(symptoms);
        msg = rooms[i].getHistory().getSymptom();
         perro = true;

    }
    }
  }


  return msg;
  }




}













