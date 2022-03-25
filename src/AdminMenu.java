import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static model.RoomType.valueOf;

public class AdminMenu {

    private final static AdminResource adminResource = AdminResource.getAdminResource();

    public static void adminMenu() {
        String text = "";
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            if (text.length() == 1) {
                switch (text.charAt(0)) {
                    case '1':
                        displayAllCustomers();
                        break;
                    case '2':
                        displayAllRooms();
                        break;
                    case '3':
                        displayAllReservations();
                        break;
                    case '4':
                        addRoom();
                        break;
                    case '5':
                        MainMenu.printMainMenu();
                        break;
                    default:
                        System.out.println("Unknown action\n");
                        break;}
            } else {
                System.out.println("Error: Invalid order\n");}
        }

    private static void printAdminMenu() {
        System.out.print("""

                Admin Menu
                1. See all Customers
                2. See all Rooms
                3. See all Reservations
                4. Add a Room
                5. Back to Main Menu
                
                """);
    }

    private static void displayAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
    }

    private static void displayAllRooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
    }

    private static void displayAllReservations() {
        adminResource.displayAllReservations();
    }

    private static void addRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Please enter a room number:");
        String roomNumber = scanner.nextLine();
        System.out.println("Please enter the price/night:");
        double roomPrice = scanner.nextDouble();
        System.out.println("Please enter the room type:  (SINGLE/DOUBLE)");
        RoomType roomType = valueOf(scanner.next());

        Room room = new Room(roomNumber, roomPrice, roomType);

        adminResource.addRoom((List<IRoom>) room);
        System.out.println("Room has been added Successfully");

    }
}
