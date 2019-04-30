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


  public String addPetToAvailableRoom (Mascot current){

    String msg = "";
    boolean found = false;

    for(int i =0; i< rooms.length && !found; i++){

      if(rooms[i].getAvailability()){
        found = true;
        rooms[i].getHistory().setDatas(current);
        rooms[i].setAvailability(false);

        msg = "Se agrego exitosamente a "+current.getNamePet()+" en el cuarto " + (i+1);
      }
    }
    if(!found){
      msg = "No se pudo hospitalizar porque no se encontro un cuarto vacio.";
    }

    return msg;
  }



public String hospitalize(String idclient, String nameMascot){

  String msg = "";
  Mascot andy = null;
  for(int i =0; i<clients.size() && andy==null; i++){
    if(clients.get(i).getID() == idclient){
        andy = clients.get(i).findPet(nameMascot);
        if(andy==null){
          msg = "El cliente no tiene una mascota con ese nombre";
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






//nn

public String showClients(){
  String msj = "";
  msj += clients.size();
   for(int i = 0 ; i<clients.size(); i++){
     msj +=  (i+1) + clients.get(i).infoClient();
  }
  return msj;



}
public String darAlta(Mascot mascotsNames){
 boolean recorrido = false;
 String msj = "";
    for(int i = 0; i < rooms.length && !recorrido; i++){
      if(!rooms[i].getAvailability()){
        if(rooms[i].getHistory().getDatas().equals(mascotsNames)){
          rooms[i].getHistory().setDatas(null);
          recorrido= true;
          rooms[i].setAvailability(true);
          msj = "Se saco La mascota del cuarto";
        }
      }
      else{
        msj = "No se encontro su animal hospitalizado";
      }
    }
    return msj;
  }


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



public String showRooms(){
  String msj="";
  for ( int i =0; i <rooms.length;i++){
    msj+=rooms[i].showRoomInformation();
  }
  return msj;
}
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



//lab 4
public double ingresService(){

double cost =0.0;

for (int i=0;i<services.size();i++){


  cost+=services.get(i).getCost();
}

return cost;



}


//lab4

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

public double promedioIngresService(){


  return ingresService()/services.size();
}

//lab 3 ingreso historia clinica 
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
//lab4

public double ingresosTotalesDeLaVeterinaria(){
  return promedioIngresService()+costOfHospitalizatee();
}




public String agregarmedicina(String name, double dose, double costDose, double frecuency,int  number){
String msg="";
boolean centinela=false ;
  for (int i =0;i<rooms.length && !centinela; i++ ){

    if (number==rooms[i].getNumMiniroom()){
      
       msg=rooms[i].drugHistry( name,  dose, costDose,  frecuency);
  }
}
   if (centinela==false){
    msg="el numero digitado es incorrecto";
   }
return msg;
}




public String minucuartos(){

String msg="";

for (int i=0;i<rooms.length;i++){
  if (rooms[i].getAvailability()==false){
    msg +=rooms[i].getNumMiniroom()+"\n";
  }
}
  return msg;
}






public String modificDatas(String id , String andress,String telephone){
  String msg="No se pudo modificar los datos del cliente";
  boolean centinela=false;

  for (int i=0;i<clients.size() && !centinela ;i++){

    if ( id.equals(clients.get(i).getID()) ){

     clients.get(i).modificDatas(andress, telephone);
      centinela = true;
      

    }
  }

  if (centinela){
    msg="Se actualizaron los datos del cliente";
  }
return msg ;


}






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




public void addNotesToHospitalization(String clientIdentify, String nameClientPe, String notes){

boolean perro = false;

for(int i = 0; i < rooms.length && perro == false; i++){
      if(rooms[i].history.getDatas().getOwner().getID().equals(clientIdentify)){
    if(rooms[i].history.getDatas().getNamePet().equals(nameClientPe)){

         rooms[i].addNotesToPet(notes);
         perro = true;

    }
    
  }
  }
}




 }










