package school.faang.task_44736;

import java.util.*;

public class BookingSystem {
    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    private BookingNotifier notifier;

    public BookingSystem(BookingNotifier notifier) {
        this.notifier = notifier;
    }

    public List<Booking> findBookingsForDate(String date) {
        List<Booking> bookingDate = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getDate().equals(date)) {
                bookingDate.add(booking);
            }
        }
        return bookingDate;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (checkAvailability(room, date, timeSlot)
                    && room.getAmenities().containsAll(requiredAmenities)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            notifier.notifyObservers(booking, "room cancelled");
            return true;
        }
        return false;
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Room not found by id: " + roomId);
        }
        if (checkAvailability(room, date, timeSlot)) {
            Booking booking = new Booking(room, date, timeSlot);
            bookings.put(booking.getBookingId(), booking);
            notifier.notifyObservers(booking, "room booked");
        }

    }

    private boolean checkAvailability(Room room, String date, String timeSlot) {
        for (Booking booking : bookings.values()) {
            if (booking.getRoom().getRoomId() == room.getRoomId()
                    && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }

    public void addRoom(Room room) {
        rooms.putIfAbsent(room.getRoomId(), room);
    }

    public void removeRoom(int roomId) {
        Room room = rooms.get(roomId);
        if (room != null) {
            rooms.remove(roomId);
        }
    }


}
