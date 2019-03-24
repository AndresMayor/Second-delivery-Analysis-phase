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


//Relations

    private HumanClient owner;

//Metodo Constructor 

public Mascot(String name,double weight,int age,char type,HumanClient owner){
	this.name=name;
	this.weight=weight;
	this.age=age;
	this.type=type;
	this.owner=owner;


}


public String getNamePet(){
	return name;
}
public void setName(String name){
	this.name=name;
}


public double getWeight(){
	return weight;
}
public void setWeight(double weight){
	this.weight=weight;
}

public int getAge(){
	return age;
}
public void setAge(int age){
	this.age=age;
}


public char getType(){
	return type;
}
public void setType(char type){
	this.type=type;
}

public HumanClient getOwner(){
	return owner;
}
public void setOwner(HumanClient owner){
	this.owner=owner;
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
	return msj;


}
}


