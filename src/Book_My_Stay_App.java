/**
 * UseCase2RoomInitialization
 *
 * Demonstrates room initialization and static availability
 * for the Book My Stay Hotel Booking System.
 *
 * @author Student
 * @version 2.1
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     Book My Stay Application    ");
        System.out.println("        Version 2.1              ");
        System.out.println("=================================\n");

        // Creating room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailable = 10;
        int doubleRoomAvailable = 5;
        int suiteRoomAvailable = 2;

        // Display room details
        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailable);

        System.out.println("\nDouble Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailable);

        System.out.println("\nSuite Room Details:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailable);

        System.out.println("\nThank you for using Book My Stay!");
    }
}