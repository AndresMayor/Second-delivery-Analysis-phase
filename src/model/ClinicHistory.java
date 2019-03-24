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
    





public double costOfHospitalizate(int actualDay, int actualMonth, int actualYear){

double total = 0.0;
int diasPreciso = admissionDate.getFrecuencyOfTheMedicament(actualDay, actualMonth, actualYear);
for(int i = 0; i <  medicines.size(); i++){
double totalCost = medicines.get(i).calculatedDose();

if(datas.getType() != (Mascot.CAT)){
    if(datas.getWeight() >= 1.0 && 3.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 10000)+ totalCost;
    }else if(datas.getWeight() >= 3.1 && 10.0 <= datas.getWeight()){
        total += (double) (diasPreciso* 12000)+ totalCost;
    }else if(datas.getWeight() >= 10.1 && 20.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 15000)+ totalCost;
 }else if(datas.getWeight() > 20.0 ){
     total +=(double) (diasPreciso * 20000)+ totalCost;
 }
} else if(datas.getType() != (Mascot.DOG)){
    if( datas.getWeight() >= 1.0 && 3.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 15000)+ totalCost;
    }else if(datas.getWeight() >= 3.1 && 10.0 <= datas.getWeight()){
        total += (double)(diasPreciso * 17000)+ totalCost;
    }else if(datas.getWeight() >= 10.1 && 20.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 20000)+ totalCost;
 }else if(datas.getWeight() > 20.0 ){
     total += (double) (diasPreciso * 25000)+ totalCost;
 }

}else if(datas.getType()!=(Mascot.BIRD)){
    if( datas.getWeight() >= 1.0 && 3.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 10000)+ totalCost;
    }else if(datas.getWeight() >= 3.1 && 10.0 <= datas.getWeight()){
        total +=(double)  (diasPreciso * 12000)+ totalCost;
    }else if(datas.getWeight() >= 10.1 && 20.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 20000)+ totalCost;
 }else if(datas.getWeight() > 20.0 ){
     total +=(double) (diasPreciso * 25000)+ totalCost;
 }

}else if(datas.getType()!=(Mascot.OTHER)){
    if(  datas.getWeight() >= 1.0 && 3.0 <= datas.getWeight()){
        total += (double)  (diasPreciso * 10000)+ totalCost;
    }else if(datas.getWeight() >= 3.1 && 10.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 17000)+ totalCost;
    }else if(datas.getWeight() >= 10.1 && 20.0 <= datas.getWeight()){
        total += (double) (diasPreciso * 30000)+ totalCost;
 }else if(datas.getWeight() > 20.0 ){
     total += (double) (diasPreciso * 30000)+ totalCost;
 }

}

}
return total;

}

}