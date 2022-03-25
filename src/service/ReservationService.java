package service;
import java.util.*;

import model.IRoom;
import model.Reservation;
import model.Customer;



public class ReservationService {

    private final static List<Reservation> reservations = new ArrayList<>();
    private final static List<IRoom> rooms = new ArrayList<>();

    private static ReservationService Instance;

    private ReservationService() {
    }

    private final static ReservationService reservationService = null;

    public static ReservationService getReservationService() {
        if (reservationService == null) {
            Instance = new ReservationService();
        }
        return Instance;
    }

    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public static IRoom getARoom(String roomId) {
        return rooms.get(Integer.parseInt(roomId));
    }

    // I have no idea with the statement java.until.List can't be applied to java.lang.String
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> availableRooms = new ArrayList<>();
        if (reservations.isEmpty())
            return rooms;
        for (IRoom roomLayer : rooms) {
            for (Reservation resLayer : reservations) {
                while (resLayer.getRoom().equals(roomLayer.getRoomNumber())) {
                    while (checkInDate.after(resLayer.getCheckOutDate())
                            || checkOutDate.before(resLayer.getCheckInDate())) {
                        availableRooms.add(roomLayer);
                        System.out.println("Available rooms: " + availableRooms);
                    }
                }
            }
        }
        return availableRooms;
    }

//add default days to get alternative recommendation rooms.

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        Optional<Reservation> reservation = reservations.stream().filter(r -> customer.equals(r.getCustomer())).findFirst();
        return (Collection<Reservation>) reservation.orElse(null);
    }

    public List<IRoom> getAllRooms(){
        return rooms;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}