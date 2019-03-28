/** | Name :Andrés Mayor Aldana    |
    | Algoritmos y Programacion    |
    | Univesidad Icesi             |
    | A00359333                    |
    | Camilo Barrios               |
    | Laboratorio 3                |    
**/
package model;
import java.util.ArrayList;

public class Veterinary{


//Relations 


private Miniroom[] rooms;
private ArrayList<ClinicHistory> histories;
private ArrayList<HumanClient> clients;


//Constructor 


public Veterinary(){

	rooms = new Miniroom[8];
	histories = new ArrayList<ClinicHistory>();
	clients = new ArrayList<HumanClient>();



}

//Get s And Set s
public Miniroom[] getRooms(){
	return rooms;
}
public void setRooms(Miniroom[] rooms){
	this.rooms=rooms;
}



public ArrayList<ClinicHistory> getHistories (){
	return histories;
}

public void setHistories(ArrayList<ClinicHistory> histories){
	this.histories= histories;
}



public ArrayList<HumanClient> getClients(){
	return clients;
}
public void setClients(ArrayList<HumanClient> clients){
	this.clients=clients;
}




public void addHistorys(ClinicHistory history1){
    histories.add(history1);
}


public void addClients(HumanClient client1){
		clients.add(client1);
}




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




public boolean avaibleRoom(){
boolean f = false;

for(int i = 0; i < rooms.length; i++){
  if(rooms[i].getAvailability()){
   f = true;
 }

}
  return f;
}



public String calculatedPay(int actualDay, int actualMonth, int actualYear){
  String msj = "";
 for(int i=0; i < histories.size(); i++){

    msj += histories.get(i).costOfHospitalizate(actualDay, actualMonth, actualYear);

 }
 return msj;
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
          msj = "Se saco el animalito del cuarto";
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
  for (int i =0; i <rooms.length;i++){
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

}
