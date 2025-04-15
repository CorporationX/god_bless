package hotels;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem implements BookingObserver {
    private List<Room> rooms;
    private List<Booking> bookings;
    private BookingNotifier notifier;
    private int bookingId = 0;

    public BookingSystem() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.notifier = new BookingNotifier();
    }

    public void addObserver(BookingObserver observer) {
        notifier.addObserver(observer);
    }

    @Override
    public void update(Booking booking, String status) {
        System.out.println("Booking Update: Booking ID " + booking.getBookingId() +
                ", Room: " + booking.getRoom().getRoomNumber() +
                ", Status: " + status);
    }

    public void addRoom(Room newRoom) {
        if (!rooms.contains(newRoom)) {
            rooms.add(newRoom);
        } else {
            System.out.println("Room already exists");
        }
    }

    public void removeRoom(int roomNumber) {
        Room roomToRemove = null;
        for (Room room : rooms) {
            if (Objects.equals(room.getRoomNumber(), roomNumber)) {
                roomToRemove = room;
            }
        }

        if (roomToRemove != null) {
            rooms.remove(roomToRemove);
            System.out.println("Room has been successfully deleted");
        } else {
            System.out.println("Room with this room number has not been found");
        }


    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAmenities().containsAll(requiredAmenities)) {
                for (Booking booking : bookings) {
                    if (Objects.equals(booking.getDate(), date) && Objects.equals(booking.getTimeSlot(), timeSlot)
                            && Objects.equals(booking.getRoom(), room)) {
                        freeRooms.add(room);
                    }
                }
            }
        }
        if (freeRooms.isEmpty()) {
            System.out.println("No available rooms found for the specified date, time, and amenities.");
        }

        return freeRooms;
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        Room room = findRoomByNumber(roomNumber);

        boolean isBooked = bookings.stream().allMatch(b -> b.getRoom().getRoomNumber() == roomNumber
                && Objects.equals(b.getDate(), date) && Objects.equals(b.getTimeSlot(), timeSlot));

        if (isBooked) {
            System.out.println("Room is already booked for this date and time slot.");
        }
        bookingId++;
        Booking newBooking = new Booking(bookingId, room, date, timeSlot);
        bookings.add(newBooking);
        notifier.notifyObservers(newBooking, "created");
    }

    public void cancelBooking(int bookingId) {
        Booking bookingToDelete = null;

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                bookingToDelete = booking;
            }
        }

        if (bookingToDelete != null) {
            bookings.remove(bookingToDelete);
            notifier.notifyObservers(bookingToDelete, "CANCELLED");
        } else {
            System.out.println("No booking found");
        }


    }
}
