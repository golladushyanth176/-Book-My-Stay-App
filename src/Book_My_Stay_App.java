import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Room class representing common room properties.
 * @version 4.0
 */
abstract class Room {

    private String roomType;
    private int beds;
    private double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price per Night: ₹" + price);
    }
}

/**
 * Single Room implementation
 * @version 4.0
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 2500);
    }
}

/**
 * Double Room implementation
 * @version 4.0
 */
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 4000);
    }
}

/**
 * Suite Room implementation
 * @version 4.0
 */
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 8000);
    }
}

/**
 * RoomInventory manages room availability.
 * @version 4.0
 */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 0); // Example unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Map<String, Integer> getAllInventory() {
        return inventory;
    }
}

/**
 * SearchService handles read-only search operations.
 * @version 4.0
 */
class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("\nAvailable Rooms:\n");

        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            if (available > 0) {

                room.displayDetails();
                System.out.println("Available Rooms: " + available);
                System.out.println("----------------------------");

            }
        }
    }
}

/**
 * UseCase4RoomSearch
 * Demonstrates read-only room search functionality.
 *
 * @version 4.1
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      Book My Stay App");
        System.out.println("        Version 4.1");
        System.out.println("=================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create search service
        SearchService searchService = new SearchService(inventory);

        // Guest searches available rooms
        searchService.searchAvailableRooms();

        System.out.println("\nSearch completed. Inventory state unchanged.");
    }
}