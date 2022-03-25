package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private final static CustomerService customerService = CustomerService.getCustomerService();
    private final static ReservationService reservationService = ReservationService.getReservationService();

    private static HotelResource Instance;
    private HotelResource(){}
    private final static HotelResource hotelResource =null;
    public static HotelResource getHotelResource(){
        if(hotelResource== null){
            Instance =new HotelResource();}
        return Instance;
    }


    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        try {
            customerService.addCustomer(email, firstName, lastName);
        } catch (IllegalArgumentException exception) {
            exception.getLocalizedMessage();
        }
    }

        public IRoom getRoom (String roomNumber){
            return reservationService.getARoom(roomNumber);
        }

        public Reservation bookARoom (String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
            return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
        }

        public Collection<Reservation> getCustomerReservations (String customerEmail) {
                return reservationService.getCustomerReservation(getCustomer(customerEmail));
            }

        public Collection<IRoom> findARoom (Date checkIn, Date checkOut){
            return reservationService.findRooms(checkIn, checkOut);
        }
}



