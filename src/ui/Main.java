
/** | Name :Andrés Mayor Aldana    |
    | Algoritmos y Programacion    |
    | Univesidad Icesi             |
    | A00359333                    |
    | Camilo Barrios               |
    | Laboratorio 3                |    
**/


package ui;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;




public class Main{
	//Relations 

	private Veterinary myLittlePet;

	//initializer 

	private Scanner reader;

	public Main(){
		init();
		reader = new Scanner(System.in);
	} 

	public static void main(String[] args){
		Main m = new Main();
		m.menu();
		m.showMenu();
	}

	public void menu(){
		welcome();
	}

	public void welcome(){

    System.out.println(".............................................................................");
    System.out.println("--------------------           My Little Pet.            --------------------");
    System.out.println(".............................................................................");

	}

	public void showMenu(){

		int userInput=0;

		while(userInput!=18){
			showOptions();
			userInput = reader.nextInt();
			reader.nextLine();

	if(userInput==1){
	    System.out.println("Client name:");
		String theName = reader.nextLine();
		System.out.println("Client  iD:");
		String theiD = reader.nextLine();
		System.out.println("Client address:");
		String theAddress = reader.nextLine();
		System.out.println("Client  cell:");
		String theTelePhone = reader.nextLine();
		HumanClient clientPrincipal = new HumanClient(theName, theiD, theAddress, theTelePhone);
		System.out.println("How many pets does the client have?:");
		int quantityPets = reader.nextInt();
		reader.nextLine();
	    for(int i = 0; i < quantityPets; i++){

System.out.println("...........................................................................");

			System.out.println("Mascot "+(i+1)+":");


			System.out.println("Mascot name:");
			String mascotName = reader.nextLine();


			System.out.println("Mascot weight:");
			double mascotWeight = reader.nextDouble();
			reader.nextLine();


			System.out.println("Mascot age:");
			int mascotAge = reader.nextInt();
			reader.nextLine();

			System.out.println("Mascot Heigth:");
			double  mascotHeigth = reader.nextDouble();
			reader.nextLine();

			System.out.println("Mascot type(G for cat, P for dog, A for bird, O for others):");
			char mascotType = reader.next().charAt(0);

			Mascot mascotPrincipal = new Mascot(mascotName, mascotWeight, mascotAge, mascotType, clientPrincipal,mascotHeigth);

			clientPrincipal.addMascots(mascotPrincipal);
		}
		    myLittlePet.addClients(clientPrincipal);

		System.out.println("The client was added successfully");

	}
			
    else if(userInput==2){
		
     int error = 0;
		    while (error == 0){
			System.out.println("owner's identifier:");
			String theID = reader.nextLine();
			if(myLittlePet.findCustomer(theID) == true){
			System.out.println("¿What pet do you want to hospitalize?");
			System.out.println(myLittlePet.namesMascots(theID));
			int option = reader.nextInt();
			reader.nextLine();
            System.out.println("¿What are the symptoms?");
			String sysmptoms = reader.nextLine();
			System.out.println("¿What is the diagnostic?");
			String diagnostic = reader.nextLine();
            Mascot petsHos = myLittlePet.clint(theID).getMascots().get(option-1);
			System.out.println("Day of join:");
			int tDay = reader.nextInt();
			reader.nextLine();
			System.out.println("Month of join:");
			int tMonth = reader.nextInt();
			reader.nextLine();
			System.out.println("Year of join:");
			int tYear = reader.nextInt();
			reader.nextLine();
			Date today = new Date(tDay, tMonth, tYear);
			ClinicHistory newClinic = new ClinicHistory(true, sysmptoms, diagnostic, petsHos , today, null);
			System.out.println("¿How many medicines has the pet?");
			int quantityMedicines = reader.nextInt();
			reader.nextLine();
			for(int i = 0; i < quantityMedicines; i++){
			System.out.println("--------------------------------");
			System.out.println("¿What is the name of the medicine?");
			String theName = reader.nextLine();
			System.out.println("¿How many doses of the medicine?");
			double theDoses = reader.nextDouble();
			reader.nextLine();
			System.out.println("¿What is the cost by dose?");
			double costByDose = reader.nextDouble();
			reader.nextLine();
			System.out.println("¿What is the frequency to take the medicine?");
			double theFrequency = reader.nextDouble();
			reader.nextLine();
			Medicine temporalDrug = new Medicine(theName, theDoses, costByDose,theFrequency);
			newClinic.addMedicines(temporalDrug);
			}
			myLittlePet.hospitalizeAPet(newClinic);
			System.out.println("The pet was hospitalized successfully");
			error = 1;
			}
			else{
				System.out.println("The client wasn't finded, please enter the identifier again");
			}
			}
			}
	
	else if(userInput==3){

    System.out.println("Enter the ID of the client.");
    String idclient = reader.nextLine ();
    System.out.println("Enter the name of the animal");
    String namesMascot = reader.nextLine();
    System.out.println(myLittlePet.hospitalize(idclient, namesMascot));

			}

	else if(userInput==4){

    System.out.println(myLittlePet.showRooms());

            }

	else if(userInput==5){

    System.out.println(myLittlePet.costOfHospitalizatee());

			}

	else if (userInput==6){

    System.out.println(myLittlePet.showClients());
    System.out.println("Enter the customer's identification to exit with  the animal.");
    String idClientt = reader.nextLine();
    System.out.println("Enter the pet NAME to high.");
    String nampe = reader.nextLine();
    System.out.println(myLittlePet.findToHospitalize(idClientt,nampe));

    }

    else if(userInput==7){

    System.out.println("To open information");
    System.out.println(myLittlePet.showClients());

			}

	else if (userInput==8){

	System.out.println(myLittlePet.ingresService());

			}
	else if (userInput==9){

    addServices();

			}
	else if (userInput==10){

	System.out.println(myLittlePet.promedioIngresService());

			}
    else if (userInput==11){

    System.out.println(myLittlePet.ingresosTotalesDeLaVeterinaria());

           }

    else if (userInput==12){

    addDrugs();

           }

     else if (userInput==13){
          	
System.out.println("Digite el id del cliente por favor");
String  id  = reader.nextLine();


System.out.println("Digite la dirección que quiere actualizar por favor");
String andress = reader.nextLine();

System.out.println("Por favor digite el telefono que quiere actualizar por favor");
String telephone = reader.nextLine();

System.out.println(myLittlePet.modificDatas(id,andress,telephone));

           }

      else if (userInput==14){

System.out.println("Digite el dia ");
int  dia   = reader.nextInt();
reader.nextLine();

System.out.println("Digite el mes  ");
int  mes    = reader.nextInt();
reader.nextLine();

System.out.println("Digite el anio ");
int  anio    = reader.nextInt();
reader.nextLine();

Date n = new Date (dia,mes,anio);
System.out.println(myLittlePet.calculateFecha(n));

           }

      else if (userInput==15){

  System.out.println("Digite el ID del dueño de la mascota           ");
  String clientIdentify = reader.nextLine();
  
  System.out.println("Digite el nombre de la mascota                 ");
  String nameClientPet = reader.nextLine();

  System.out.println("Digite las notas que desea agregar al diagnostico del paciente");
  String notes = reader.nextLine();

  System.out.println(myLittlePet.addNotesToHospitalization(clientIdentify,nameClientPet,notes));

}
      else if (userInput==16){

  System.out.println("Digite el ID del dueño de la mascota:           ");
  String clientIdentify = reader.nextLine();
  
  System.out.println("Digite el nombre de la mascota:                 ");
  String nameClientPet = reader.nextLine();

  System.out.println("Digite los sintomas  que desea agregar:         ");
  String notes = reader.nextLine();

  System.out.println(myLittlePet.addSymptoms(clientIdentify,nameClientPet,notes));

      }

      else if (userInput==17){

    System.out.println("DIGITE LA FECHA DE INICIO");
    System.out.println("Digite el dia:  ");
    int  dia   = reader.nextInt();
    reader.nextLine();
    System.out.println("Digite el mes:  ");
    int  mes    = reader.nextInt();
    reader.nextLine();
    System.out.println("Digite el año: ");
    int  anio    = reader.nextInt();
    reader.nextLine();
    Date n = new Date (dia,mes,anio);

    System.out.println("Digite La Fecha final");
    System.out.println("Digite el dia: ");
    int  di   = reader.nextInt();
    reader.nextLine();
    System.out.println("Digite el mes:  ");
    int  me    = reader.nextInt();
    reader.nextLine();
    System.out.println("Digite el año: ");
    int  ani    = reader.nextInt();
    reader.nextLine();
    Date t = new Date (di,me,ani);

    System.out.println(myLittlePet.calculateFecha(n,t));

}
}
}


public void showOptions(){
  System.out.println("---------------------------------------------------------------------------");
  System.out.println("PLEASE TYPE THE OPTION YOU WANT TO REVIEW."                                 );
  System.out.println("                                                                          |");
  System.out.println("1.Register Client and Pet.\n"                                               );
  System.out.println("                                                                          |");
  System.out.println("2.Hospitalize the pet.\n"                                                   );
  System.out.println("                                                                          |");
  System.out.println("3.Look for your pet in the hospital.                                       ");
  System.out.println("                                                                          |");
  System.out.println("4.Information about mini roms availability                                 ");
  System.out.println("                                                                          |");
  System.out.println("5.He calculates total income"                                               );
  System.out.println("                                                                          |");
  System.out.println("6.Give the exit to the pet.                                                ");
  System.out.println("                                                                          |");
  System.out.println("7.Imformacion clients.                                                     ");
  System.out.println("                                                                          |");
  System.out.println("8.Ingresos por servicios                                                   ");
  System.out.println("                                                                          |");
  System.out.println("9.agregar servicio                                                         ");
  System.out.println("                                                                          |");
  System.out.println("10.promedio de ingresos por servicios                                      ");
  System.out.println("                                                                          |");
  System.out.println("11 ingresos totales                                                        ");
  System.out.println("                                                                          |");
  System.out.println("12 agregar medicina                                                        ");
  System.out.println("                                                                          |");
  System.out.println("13.Modificar datos del cliente                                             ");
  System.out.println("                                                                          |");
  System.out.println("14.Promedio de ingresos de la veterinaria en una semana                    ");
  System.out.println("                                                                          |");
  System.out.println("15.Agregar notas al diagnostico de la mascota.                             ");
  System.out.println("                                                                          |");
  System.out.println("16.Agregar nuevos  sintomas                                                ");
  System.out.println("                                                                          |");
  System.out.println("17.Promedio de ingresos de la veterinaria entre una  fecha inicial y final ");
  System.out.println("                                                                          |");
  System.out.println("18.Salir del programa.                                                     ");
  System.out.println("                                                                          |");
  System.out.println("---------------------------------------------------------------------------");


}

public void init(){

//	public HumanClient(String name,String iD,String address,String telePhone){

HumanClient client1 = new HumanClient("Andres","122","Cra 33a #29-56","3237985");
HumanClient client2 = new HumanClient("Richard","123","Cra 33a #29-47","3213211");

//public Mascot(String name,double weight,int age,char type,HumanClient owner){

Mascot mascot1 = new Mascot("Bonny",20.0,3,'G',client1,1.10);
Mascot mascot2 = new Mascot("Zeus",22.0,5,'P',client2,80.0);
Mascot mascot3 = new Mascot("Hercules",30.0,6,'P',client2,1.20);
client1.getMascots().add(mascot1);
mascot1.setOwner(client1);
client2.getMascots().add(mascot2);
mascot1.setOwner(client2);
client2.getMascots().add(mascot3);
mascot1.setOwner(client2);

Date admissionDate1 = new Date (22,03,2018);
Date exitDate1 = new Date(10,03,2019);
Date admissionDate2 = new Date (20,02,2018);
Date exitDate2 = new Date(20,02,2019);
Date admissionDate3 = new Date (26,03,2019);


//public Medicine(String name, double dose, double costDose, double frecuency){

Medicine medicine1 = new Medicine("Meloxic",15.0,10.000,23.0);
Medicine medicine2 = new Medicine("Marboquin",13.0,12.000,24.0);
Medicine medicine3 = new Medicine("Mirrapel",11.0,9.000,14.0);
Medicine medicine4 = new Medicine("Drontal",10.0,8.000,9.0);

// public ClinicHistory(boolean status,String symptom,String diagnosis,Mascot datas,Date admissionDate,Date exitDate){

ClinicHistory history1 = new ClinicHistory(true,"the animal is itchy","Critical",mascot1, admissionDate1, exitDate1);
ClinicHistory history2 = new ClinicHistory(true,"the animal is fever ","low risk",mascot2,admissionDate2,exitDate2);
ClinicHistory history3 = new ClinicHistory(true, "the animal is infecte bite","Critical",mascot3,admissionDate3,null);
history1.addMedicines(medicine1);
history1.addMedicines(medicine2);
history2.addMedicines(medicine3);
history3.addMedicines(medicine4);

//Status Minirooms

Miniroom room1 = new Miniroom(true,1,null);
Miniroom room2 = new Miniroom(true,2,null);
Miniroom room3 = new Miniroom(true,3,null);
Miniroom room4 = new Miniroom(true,4,null);
Miniroom room5 = new Miniroom(false,5,history3);
Miniroom room6 = new Miniroom(true,6,null);
Miniroom room7 = new Miniroom(false,7,history1);
Miniroom room8 = new Miniroom(false,8,history2);
Miniroom[] rooms = {room1,room2,room3,room4,room5,room6,room7,room8};

 myLittlePet = new Veterinary();
     	myLittlePet.setRooms(rooms);
		myLittlePet.getHistories().add(history1);
		myLittlePet.getHistories().add(history2);
        myLittlePet.getHistories().add(history3);
		myLittlePet.getClients().add(client1);
		myLittlePet.getClients().add(client2);
		myLittlePet.getClients().add(client2);


Date fecha = new Date (20,02,2018);
Service service1 = new Service(Service.PET_BATHV,fecha,mascot2);
myLittlePet.addService(service1);

Date fecha1 = new Date (20,05,2018);
Service service2 = new Service(Service.NAIL_CUTTING,fecha1,mascot2);
myLittlePet.addService(service2);

Date fecha2 = new Date (15,04,2016);
Service service3 = new Service(Service.VACCINATIONS,fecha2,mascot3);
myLittlePet.addService(service3);
}

public void addServices (){
    System.out.println("Type of the service ");
    System.out.println("1.Pet bath in the veterinary. \n 2.Pet bath at home \n 3.Nail cutting \n 4.Dental prophylaxis \n 5.Vacine ");
    int type   = reader.nextInt();
    reader.nextLine();
    String typeService="";
    if (type ==1 ){
    	typeService=Service.PET_BATHV;
    }
    else if (type==2){
    	typeService=Service.PET_BATHD;
    }
    else if (type==3){
    	typeService=Service.NAIL_CUTTING;
    }
    else if (type==4){
    	typeService=Service.DENTA_PRO;
    }
    else if (type==5){

    	typeService=Service.VACCINATIONS;
    }

     System.out.println("Day ");
     int day  = reader.nextInt();
     reader.nextLine();
     System.out.println("Month");
     int month = reader.nextInt();
     reader.nextLine();
     System.out.println("Year");
     int year = reader.nextInt();
     reader.nextLine();
     System.out.println("Identifier Owner ");
     String id = reader.nextLine();
     
     System.out.println(myLittlePet.returnClient(id).nameMascots());
     int option =reader.nextInt();
     reader.nextLine();

     Mascot fiat =myLittlePet.returnClient(id).getMascots().get(option-1);

     Date dateRealization = new Date (day,month,year);
     Service service1 = new Service(typeService,dateRealization,fiat);

   
}
public void addDrugs(){

    System.out.println("Nombre de la medicina ");
	String name  = reader.nextLine();
	System.out.println("Dosis ");
	double dose  = reader.nextInt();
	reader.nextLine();
	System.out.println("Costo de la dosis ");
	double costDose  =reader.nextInt();
	reader.nextLine();
	System.out.println("frecuencia de la dosis ");
	double  frecuency =reader.nextInt();
	reader.nextLine();
    System.out.println("En que mini cuarto esta la mascota ");
    System.out.println(myLittlePet.minucuartos());
    int number = reader.nextInt();
	reader.nextLine();
    System.out.println(myLittlePet.agregarmedicina(name,dose,costDose,frecuency,number));
}

}

