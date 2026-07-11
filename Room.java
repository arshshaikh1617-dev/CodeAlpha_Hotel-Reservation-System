public class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Book room
    public void bookRoom() {
        available = false;
    }

    // Cancel booking
    public void cancelBooking() {
        available = true;
    }

    // Display room details
    public void displayRoom() {
        System.out.println(
                "Room No: " + roomNumber +
                " | Category: " + category +
                " | Price: ₹" + price +
                " | Available: " + (available ? "Yes" : "No"));
    }
}