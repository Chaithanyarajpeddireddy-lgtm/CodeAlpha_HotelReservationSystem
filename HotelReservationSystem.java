import java.util.*;
import java.io.*;

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeRooms();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" HOTEL RESERVATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Search Reservation");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    viewReservations();
                    break;

                case 4:
                    searchReservation();
                    break;

                case 5:
                    cancelReservation();
                    break;

                case 6:
                    saveReservations();
                    break;

                case 7:
                    saveReservations();
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 7);
    }

    public static void initializeRooms() {

        rooms.add(new Room(101,"Standard",1000));
        rooms.add(new Room(102,"Standard",1000));

        rooms.add(new Room(201,"Deluxe",2000));
        rooms.add(new Room(202,"Deluxe",2000));

        rooms.add(new Room(301,"Suite",3500));
        rooms.add(new Room(302,"Suite",3500));
    }

    public static void viewRooms() {

        System.out.println("\nRoom Details");

        for(Room room : rooms) {

            System.out.println(
                    room.getRoomNumber() + " | " +
                    room.getRoomType() + " | ₹" +
                    room.getPricePerNight() + " | " +
                    (room.isAvailable() ?
                            "Available" : "Booked"));
        }
    }

    public static void bookRoom() {

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        viewRooms();

        System.out.print("Enter Room Number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Number of Days: ");
        int days = sc.nextInt();

        Room selectedRoom = null;

        for(Room room : rooms) {

            if(room.getRoomNumber() == roomNumber
                    && room.isAvailable()) {

                selectedRoom = room;
                break;
            }
        }

        if(selectedRoom == null) {

            System.out.println(
                    "Room unavailable or invalid.");
            return;
        }

        Reservation reservation =
                new Reservation(name,
                        selectedRoom,
                        days);

        reservations.add(reservation);

        selectedRoom.setAvailable(false);

        System.out.println(
                "\nBooking Successful!");

        System.out.println(
                "Bill Amount: ₹" +
                        reservation.getTotalAmount());
    }

    public static void viewReservations() {

        if(reservations.isEmpty()) {

            System.out.println(
                    "No Reservations Found.");
            return;
        }

        for(Reservation r : reservations) {

            System.out.println(
                    r.getCustomerName()
                    + " | Room "
                    + r.getRoom().getRoomNumber()
                    + " | Days: "
                    + r.getNumberOfDays()
                    + " | ₹"
                    + r.getTotalAmount());
        }
    }

    public static void searchReservation() {

        System.out.print(
                "Enter Customer Name: ");

        String name = sc.nextLine();

        boolean found = false;

        for(Reservation r : reservations) {

            if(r.getCustomerName()
                    .equalsIgnoreCase(name)) {

                System.out.println(
                        "Room: "
                                + r.getRoom()
                                .getRoomNumber());

                System.out.println(
                        "Amount: ₹"
                                + r.getTotalAmount());

                found = true;
            }
        }

        if(!found) {

            System.out.println(
                    "Reservation Not Found.");
        }
    }

    public static void cancelReservation() {

        System.out.print(
                "Enter Customer Name: ");

        String name = sc.nextLine();

        Iterator<Reservation> iterator =
                reservations.iterator();

        while(iterator.hasNext()) {

            Reservation r =
                    iterator.next();

            if(r.getCustomerName()
                    .equalsIgnoreCase(name)) {

                r.getRoom()
                        .setAvailable(true);

                iterator.remove();

                System.out.println(
                        "Reservation Cancelled.");

                return;
            }
        }

        System.out.println(
                "Reservation Not Found.");
    }

    public static void saveReservations() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "reservations.txt");

            for(Reservation r :
                    reservations) {

                writer.write(
                        r.toString() + "\n");
            }

            writer.close();

            System.out.println(
                    "Data Saved Successfully.");

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }
}