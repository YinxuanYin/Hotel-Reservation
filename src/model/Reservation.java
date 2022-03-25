package model;
import java.util.Date;


public class Reservation {
    public Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;
//class variables
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer= customer;
        this.room= room;
        this.checkInDate= checkInDate;
        this.checkOutDate= checkOutDate;
    }
//constructor to initialize variables
    public Customer getCustomer(){return customer;}
    public IRoom getRoom(){return room;}
    public Date getCheckInDate(){return checkInDate;}
    public Date getCheckOutDate(){return checkOutDate;}
// provide access to instance variables:room, checkInDate, checkOutDate


    //description of current reservation in 4 lines
    @Override
    public String toString() {
        return "Customer: " + this.customer.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheck-in Date:" + this.checkInDate.toString()
                + "\nCheck-out Date: " + this.checkOutDate.toString();
    }

}
