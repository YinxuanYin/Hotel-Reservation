package model;
public class Room implements IRoom{
//instance variables
    private final String roomNumber;
    private final Double price;
    private final RoomType enumeration;
    
//constructor to initialize variables
    public Room( String roomNumber,  Double price,  RoomType enumeration){
        this.roomNumber= roomNumber;
        this.price= price;
        this.enumeration= enumeration;
    }
//Access method: provide access to instance variables
    public String getRoomNumber(){
        return this.roomNumber;
    }
    public Double getRoomPrice(){
        return this.price;
    }
    public RoomType getRoomType(){
        return this.enumeration;
    }
    public Boolean isFree(){ return this.price.equals(0.0);}
//get a description of the current state of Room(room number,price,room type)
    @Override
    public String toString(){
        return"Room Number: "+this.roomNumber+"Price: $"+this.price+"Enumeration: "+this.enumeration;
    }
}
