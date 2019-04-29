package model;

import java.util.ArrayList;

public class HumanClient{


//Atributos


	private String name;
	private String iD;
	private String address;
	private String telePhone;


//Relations

	private ArrayList<Mascot> mascots;


//Metodo Constructor

	public HumanClient(String name,String iD,String address,String telePhone){
		this.name=name;
		this.iD=iD;
		this.address=address;
		this.telePhone=telePhone;
		mascots = new ArrayList<Mascot>();
	}


//getters and setters

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}



	public String getID(){
		return iD;
	}
	public void setID(String iD){
		this.iD=iD;
	}


	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}


	public String getTelePhone(){
		return telePhone;
	}
	public void setTelePhone(String telePhone){
		this.telePhone=telePhone;
	}


	public ArrayList<Mascot> getMascots(){
		return mascots;
	}
	public void setMascots(ArrayList<Mascot> mascots){
		this.mascots=mascots;

	}

	//agg Mascot
	public void addMascots(Mascot  mascots1){
		mascots.add(mascots1);
	}

	//
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


public String infoClient(){
String msj = "";
msj += "+--------------------------------------------------------------+\n";
msj += "|  Nombre del CLiente: " + name + "\n";
msj += "| iD del Cliente: " + iD+ "\n";
msj += "| Direccion de residencia: " + address + "\n";
msj += "| Numero de contacto: " + telePhone + "\n";
msj += "+--------------------------------------------------------------+\n";

int j = 0;
for(int i = 0; i<mascots.size(); i++){
	++j;
msj += "Pet"+ j + "";
msj += mascots.get(i).showInfoPet();
}
return msj;
}







	public void modificDatas(String address, String telePhone){
		this.address = address;
		this.telePhone=telePhone;
	}

}

