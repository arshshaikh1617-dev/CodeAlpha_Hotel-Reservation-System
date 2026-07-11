import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;

    // Constructor
    public Hotel() {
        rooms = new ArrayList<>();

        // Standard Rooms
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        // Deluxe Rooms
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));

        // Suite Rooms
        rooms.add(new Room(301, "Suite", 5000));
    }

    // Display available rooms
    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.displayRoom();
            }
        }
    }

    // Find room by room number
    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Return all rooms
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}