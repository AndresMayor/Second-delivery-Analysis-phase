package model;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class ClinicHistory{

//Atributos
    private boolean status;
    private String symptom;
    private String diagnosis;

//Relations 

    private ArrayList<Medicine> medicines;
    private Date admissionDate;
    private Date exitDate;
    private Mascot datas;


//Metodo Constructor 


    public ClinicHistory(boolean status,String symptom,String diagnosis,Mascot datas,Date admissionDate,Date exitDate){
    	this.status=status;
    	this.symptom=symptom;
    	this.diagnosis=diagnosis;
    	this.datas=datas;
    	this.admissionDate=admissionDate;
    	this.exitDate=exitDate;
        medicines = new ArrayList<Medicine>();
    }


//get and set

    public boolean getStatus(){
    	return status;
    }
    public void setStatus(boolean status){
    	this.status=status;
    }


    public String getSymptom(){
    	return symptom;
    }
    public void  setSymptom(String symptom){
    	this.symptom=symptom;

    }


    public String getDiagnosis(){
    	return diagnosis;
    }
    public void setDiagnosis(String diagnosis){
    	this.diagnosis=diagnosis;
    }



    public ArrayList<Medicine> getMedicines(){
    	return medicines;
    }
    public void setMedicines(ArrayList<Medicine> medicines){
    	this.medicines=medicines;
    }


    public Date getAdmissionDate(){
    	return admissionDate;
    }
    public void setAdmissionDate(Date admissionDate){
    	this.admissionDate=admissionDate;
    }


    public Date getExitDate(){
    	return exitDate;
    }
    public void setExitDate(Date exitDate){
    	this.exitDate=exitDate;
    }


    public Mascot getDatas(){
    	return datas;
    }
    public void setDatas(Mascot datas){
    	this.datas=datas;
    }
    public void addMedicines(Medicine medicine1){
        medicines.add(medicine1);
    }
    

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
}




