package nmit03.nmit03e05.domain;

import jakarta.validation.constraints.NotEmpty;

public class MovieForm {

    @NotEmpty(message = "You must select a movie to vote")
    private String vote; 

    @NotEmpty(message = "You must provide an email")
    private String email; 

    public MovieForm(){

    }

    public String getVote(){
        return vote; 
    }

    public String getEmail(){
        return email; 
    }

    public void setVote(String vote){
        this.vote = vote;  
    }

    public void setEmail(String email){
        this.email = email; 
    }
}
