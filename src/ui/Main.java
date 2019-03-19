package ui;
import model.*;
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

	public static void Main(String [] args){
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

		while(userInput!=9){
			showOptions();
			userInput = reader.nextInt();
			reader.nextLine();


			if(userInput==1){



			}
			else if(userInput==2){




			}
			else if(userInput==3){




			}
			else if(userInput==4){




			}
			else if(userInput==5){





			}
			else if (userInput==6){







			}
			else if(userInput==7){




			}
			else if (userInput==8){




			}











		}




	}


public void showOptions(){

  System.out.println("1. ");
  System.out.println("2. ");
  System.out.println("3. ");
  System.out.println("4. ");
  System.out.println("5. ");
  System.out.println("6. ");
  System.out.println("7. ");
  System.out.println("8. ");


}

public void init(){


	
} 






}