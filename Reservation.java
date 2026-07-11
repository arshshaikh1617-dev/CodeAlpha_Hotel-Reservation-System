public class Reservation {

    private String customerName;
    private int roomNumber;
    private String category;
    private String paymentStatus;

    // Constructor
    public Reservation(String customerName, int roomNumber, String category, String paymentStatus) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Display reservation details
    public void displayReservation() {
        System.out.println("\n----- Booking Details -----");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Category      : " + category);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("---------------------------");
    }
}