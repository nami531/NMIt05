package nmit05.nmit05e02.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.PastOrPresent;


public class Dates {
    
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOne; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTwo; 

    private int action; 

    public Dates(){}

    public LocalDate getDateOne(){
        return dateOne; 
    }

    public LocalDate getDateTwo(){
        return dateTwo; 
    }

    public void setDateOne(LocalDate dateOne){
        this.dateOne = dateOne; 
    }

    public void setDateTwo(LocalDate dateTwo){
        this.dateTwo = dateTwo; 
    }

    public int getAction(){
        return action; 
    }

    public void setAction(int action){
        this.action = action; 
    }
}
