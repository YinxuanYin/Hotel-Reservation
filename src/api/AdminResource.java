package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private  final CustomerService customerService = CustomerService.getCustomerService();
    private  final ReservationService reservationService = ReservationService.getReservationService();

    private final static AdminResource adminResource= null;
    private static AdminResource Instance;
    private AdminResource(){}
    public static AdminResource getAdminResource(){
        if(adminResource == null){
            Instance = new AdminResource();
        }
        return Instance;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for(IRoom room: rooms){
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        reservationService.printAllReservation();
    }
}
