package model;


public class HumanClient{


//Atributos


	private String name;
	private int iD;
	private String address;
	private String telePhone;


//Relations

	private Mascot[] mascots;


//Metodo Constructor

	public HumanClient(String name,int iD,String address,String telePhone){
		this.name=name;
		this.iD=iD;
		this.address=address;
		this.telePhone=telePhone;
		mascots = new Mascot[5];
	}


//getters and setters

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}



	public int getID(){
		return iD;
	}
	public void setID(int iD){
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


	public Mascot[] getMascots(){
		return mascots;
	}
	public void setMascots(Mascot[] mascots){
		this.mascots=mascots;

	}

}

