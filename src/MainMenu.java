
import api.HotelResource;
import model.IRoom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    private final static HotelResource hotelResource =HotelResource.getHotelResource();

    public final void mainMenu() {
        String text = "";
        Scanner scanner = new Scanner(System.in);
                text = scanner.nextLine();
                if (text.length() == 1) {
                    switch (text.charAt(0)) {
                        case '1':
                            findAndReserveRoom();
                            break;
                        case '2':
                            seeMyReservation();
                            break;
                        case '3':
                            createAccount();
                            break;
                        case '4':
                            AdminMenu.adminMenu();
                            break;
                        case '5':
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Unknown order\n");
                            break;
                    }
                } else {
                    System.out.println("Error: Invalid order\n");
                }
            }

    public static void printMainMenu()
    {
        System.out.print("""

                Welcome to the Hotel Reservation Application
                --------------------------------------------
                1. Find and reserve a room
                2. See my reservations
                3. Create an Account
                4. Admin
                5. Exit
                Please Enter a number
                """);
    }

    private static void findAndReserveRoom() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date checkIn = new Date();
        Date checkOut = new Date();
        Date localDate = new Date();

        System.out.println("Enter Check-In date to reserve a room: \n(MM/dd/YYYY))" +
                "01/01/2022");
        String inputCheckIn = scanner.next();
        try {
            checkIn = dateFormat.parse(inputCheckIn);
        } catch (Exception exception) {
            System.out.println("Wrong Format \n Please try again");
        }
// customer enter check-in date
        System.out.println("Enter Check-Out date to reserve a room: \n(MM/dd/YYYY))" +
                "01/01/2022");
        String inputCheckOut = scanner.next();
        try {
            checkOut = dateFormat.parse(inputCheckOut);
        } catch (Exception exception) {
            System.out.println("Wrong Format \n Please try again");
        }
//customer enter check-out date

        if (checkIn.before(localDate) && checkOut.before(localDate)
                && checkIn.before(checkOut)) {
            System.out.println("Available Rooms: " + hotelResource.findARoom(checkIn, checkOut));

            System.out.println("Enter A Room number: ");
            String roomNumber = scanner.next();
            IRoom room = hotelResource.getRoom(roomNumber);

            System.out.println("Enter Your Email: ");
            String email = scanner.nextLine();
            hotelResource.bookARoom(email, room, checkIn, checkOut);
            System.out.print(
                    "Your room has been booked successfully! " +
                            "\nEmail: " + email +
                            "\nRoom: " + room +
                            "\nCheck-In DATE: " + checkIn +
                            "\nCheck-Out DATE: " + checkOut);
        } else {
            System.out.println("Irrational Input Date" +
                    "\n Please try again");
        }
    }

    private static void seeMyReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("View my reservation \n Enter your Email format: name@domain.com");
        String customerEmail = scanner.nextLine();
        System.out.println(hotelResource.getCustomerReservations(customerEmail));
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Email : (name@domain.com)");
        String email = scanner.nextLine();
        System.out.println("Enter Your First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Your Last Name:");
        String lastName = scanner.nextLine();

        hotelResource.createACustomer(email, firstName, lastName);
        System.out.println("Your account has been created Successfully");
    }
}
