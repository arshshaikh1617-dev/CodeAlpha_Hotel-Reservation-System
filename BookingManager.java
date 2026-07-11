import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BookingManager {

    private ArrayList<Reservation> reservations;
    private Hotel hotel;
    private final String FILE_NAME = "bookings.txt";

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
        reservations = new ArrayList<>();
        loadBookings();
    }

    // Book a room
    public void bookRoom(Scanner sc) {

        hotel.showAvailableRooms();

        System.out.print("\nEnter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        Room room = hotel.findRoom(roomNo);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already booked!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.println("Room Price: ₹" + room.getPrice());

        System.out.print("Proceed Payment? (yes/no): ");
        String payment = sc.nextLine();

        if (payment.equalsIgnoreCase("yes")) {

            room.bookRoom();

            Reservation reservation = new Reservation(
                    name,
                    room.getRoomNumber(),
                    room.getCategory(),
                    "Paid"
            );

            reservations.add(reservation);

            saveBookings();

            System.out.println("\nPayment Successful!");
            System.out.println("Booking Confirmed!");

        } else {

            System.out.println("Booking Cancelled.");
        }
    }

    // Cancel reservation
    public void cancelReservation(Scanner sc) {

        System.out.print("Enter Room Number to Cancel: ");
        int roomNo = sc.nextInt();

        Reservation removeReservation = null;

        for (Reservation reservation : reservations) {

            if (reservation.getRoomNumber() == roomNo) {

                removeReservation = reservation;

                Room room = hotel.findRoom(roomNo);

                if (room != null) {
                    room.cancelBooking();
                }

                break;
            }
        }

        if (removeReservation != null) {

            reservations.remove(removeReservation);

            saveBookings();

            System.out.println("Reservation Cancelled.");

        } else {

            System.out.println("No Reservation Found.");
        }
    }

    // View bookings
    public void viewBookings() {

        if (reservations.isEmpty()) {

            System.out.println("No Bookings Found.");
            return;
        }

        for (Reservation reservation : reservations) {
            reservation.displayReservation();
        }
    }

    // Save bookings
    private void saveBookings() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Reservation reservation : reservations) {

                writer.write(
                        reservation.getCustomerName() + "," +
                        reservation.getRoomNumber() + "," +
                        reservation.getCategory() + "," +
                        reservation.getPaymentStatus());

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error Saving Bookings.");
        }
    }

    // Load bookings
    private void loadBookings() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Reservation reservation = new Reservation(
                        data[0],
                        Integer.parseInt(data[1]),
                        data[2],
                        data[3]
                );

                reservations.add(reservation);

                Room room = hotel.findRoom(Integer.parseInt(data[1]));

                if (room != null) {
                    room.bookRoom();
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error Loading Bookings.");
        }
    }
}