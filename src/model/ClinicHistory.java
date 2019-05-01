package model;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
*This class contains the information of the clinical histories of the pets
*/

public class ClinicHistory{

//Atributes
    private boolean status;
    private String symptom;
    private String diagnosis;
//Relations 

    private ArrayList<Medicine> medicines;
    private Date admissionDate;
    private Date exitDate;
    private Mascot datas;


/**
*ClinicHistory constructor
*@param status the status of the history. this param must be not null.
*@param symptom the symptomsof the mascot. this param must be not null.
*@param diagnostic the diagnostic of the mascot. this param must be not null.
*@param datas the mascot this param must be not null.
*@param admissionDate the hospitalized day . this param must be not null.
*@param exitDate the discharge date. this param could be null.
*/


    public ClinicHistory(boolean status,String symptom,String diagnosis,Mascot datas,Date admissionDate,Date exitDate){
    	this.status=status;
    	this.symptom=symptom;
    	this.diagnosis=diagnosis;
    	this.datas=datas;
    	this.admissionDate=admissionDate;
    	this.exitDate=exitDate;
        medicines = new ArrayList<Medicine>();
    }



/**
*Gets the status
*@return the status of the history
*/
    public boolean getStatus(){
    	return status;
    }
/**
*Sets the status
*@param status the history's status
*/
    public void setStatus(boolean status){
    	this.status=status;
    }
/**
*Gets the symptoms
*@return the symptoms of the pet
*/
    public String getSymptom(){
    	return symptom;
    }
/**
*Sets the symptom
*@param symptom the symptom of the mascot
*/

    public void  setSymptom(String symptom){
    	this.symptom=symptom;

    }
/**
*Gets the diagnostic
*@return the clinic diagnosis
 */

    public String getDiagnosis(){
    	return diagnosis;
    }
/**
*Sets the diagnostic
*@param diagnosis the clinic diagnostic
*/
    public void setDiagnosis(String diagnosis){
    	this.diagnosis=diagnosis;
    }
/**
*Gets the medicines
*@return the medicines
*/
    public ArrayList<Medicine> getMedicines(){
    	return medicines;
    }
/**
*Set the medicines
*@param medicines the medicines
*/
    public void setMedicines(ArrayList<Medicine> medicines){
    	this.medicines=medicines;
    }

/**
 *Gets the Admission Date
*@return the admission date 
*/
    public Date getAdmissionDate(){
    	return admissionDate;
    }
/**
*Sets the join date
*@param admissionDate the admission Date
*/
    public void setAdmissionDate(Date admissionDate){
    	this.admissionDate=admissionDate;
    }
/**
*Gets the exit date
*@return the exit date
*/
    public Date getExitDate(){
    	return exitDate;
    }
/**
*Sets the exit date
*@param exitDate the exit date
*/
    public void setExitDate(Date exitDate){
    	this.exitDate=exitDate;
    }
/**
*Gets the mascot
*@return the datas of the mascot 
*/
    public Mascot getDatas(){
    	return datas;
    }
/**
*Sets the pet
*@param datas the pet
*/
    public void setDatas(Mascot datas){
    	this.datas=datas;
    }
/**
*Add new medication to the clinical history
*@param medicine1 the medicine to add
*/
    public void addMedicines(Medicine medicine1){
        medicines.add(medicine1);
    }
    /**
*to calculate the days hospitalized<br>
*pre: the clinic history was created before and the join date must be not null<br>
*post: the days hospitalized is calculated<br>
*@return the days hospitalized
 */
    public int daysHospitalized(){
        int days = 0;
        if(exitDate == null){
            GregorianCalendar date = new GregorianCalendar(admissionDate.getYear(), admissionDate.getMonth() - 1, admissionDate.getDay());
            GregorianCalendar actualDate = new GregorianCalendar();
            while (true) {
                if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
                    && (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
                    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
                    break;
                }
                date.add(Calendar.DAY_OF_MONTH, 1);
                days++;
            }
        }
        else{
            GregorianCalendar date = new GregorianCalendar(admissionDate.getYear(), admissionDate.getMonth() - 1, admissionDate.getDay());
            GregorianCalendar actualDate = new GregorianCalendar(exitDate.getYear(), exitDate.getMonth() - 1, exitDate.getDay());
            while (true) {
                if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
                    && (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
                    && (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
                    break;
                }
                date.add(Calendar.DAY_OF_MONTH, 1);
                days++;
            }
        }
        return days;
    }


/**
*to calculate the cost of the hospitalization service
*@return the cost of the hospitalized service
*/
public double hospitalizationCost(){
        double theCost = 0.0;
        if(datas.getType() == 'c'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                theCost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                theCost = 12000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                theCost = 15000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                theCost = 20000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'd'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                theCost = 15000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                theCost = 17000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                theCost = 20000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                theCost = 25000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'b'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                theCost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                theCost = 12000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                theCost = 20000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                theCost = 25000.0*daysHospitalized();
            }
        }
        else if(datas.getType() == 'o'){
            if(datas.getWeight() >= 1.0 && datas.getWeight() <= 3.0){
                theCost = 10000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 3.1 && datas.getWeight() <= 10.0){
                theCost = 17000.0*daysHospitalized();
            }
            else if (datas.getWeight() >= 10.1 && datas.getWeight() <= 20.0){
                theCost = 30000.0*daysHospitalized();
            }
            else if (datas.getWeight() > 20.0){
                theCost = 33000.0*daysHospitalized();
            }
        
        }
        for(int i = 0; i < medicines.size(); i++){
            theCost += medicines.get(i).calculatedDose();
        }
        return theCost;
    }
/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.<br>
*pre: The patient clinic story must be not null.<br>
*post: New medicines were added to the patient clinic story.<br>
*@param name The medicine name. This param must be not null.
*@param dose The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
*@param costDose The medicine cost by each dose. This param could be empty.
*@param frequency The frequency of medicine application. This param could be empty.
*@return A message that indiques if medicine was added to the patient clinic story
*/
public String addDrug(String name, double dose, double costDose, double frecuency){
String msg ="";
    if (name!=null ){
   msg="Se pudo agregar";
   Medicine drug = new Medicine(name,dose,costDose,frecuency);
   medicines.add(drug);
}
   else{
    msg="No se puedo Agregar la medicina";
   }
return msg;

    }

public void addNotesToHospitalizationFatality(String notes){

      this.diagnosis+= "\n"+notes;

}


public void addSymptoms(String symptoms){


      this.symptom+="\n"+symptoms;


}
}
