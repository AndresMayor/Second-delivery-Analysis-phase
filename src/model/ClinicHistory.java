package model;
import java.util.ArrayList;

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




}