package model;
import java.util.regex.Pattern;

public class Customer {
// instance variables
    public  String firstName;
    public  String lastName;
    public  String email;
// constructor to initialize variables
public Customer( String firstName, String lastName, String email){
    this.firstName= firstName;
    this.lastName= lastName;
    this.email=email;
}
//throw illegal exception email
    public final void main(String[] args){
        String emailRegex = "^(.+)@(.+).com$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    public String getEmail(){return this.email;}
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
//description of customer's first name, last name and email
    @Override
    public String toString() {
        return("Fist Name: "+firstName+"Last Name: "+lastName+"E-mail: "+email);
    }
}
