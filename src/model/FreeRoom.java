package model;

public class FreeRoom extends Room{
//constructor to change price to 0
    public FreeRoom( String roomNumber,Double price,RoomType enumeration){
        super(roomNumber,0.0, enumeration);
    }
// description of free room
    @Override
    public String toString(){
        return "FreeRoom= "+super.toString();
    }

}
