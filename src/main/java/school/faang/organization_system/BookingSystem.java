package school.faang.organization_system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingSystem {
    private Set<Room> rooms = new HashSet<>();
    private List<Booking> bookings = new ArrayList<>();
    BookingNotifier bookingNotifier = new BookingNotifier();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                rooms.remove(room);
                break;
            }
        }
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                boolean openTimeSlot = true;
                for (Booking booking : bookings) {
                    if (booking.getRoom() == room && booking.getDate().equals(date) && booking.getTimeSlot().equals(timeSlot)) {
                        openTimeSlot = false;
                        break;
                    }
                }
                if (openTimeSlot) {
                    Booking booking = new Booking(room, date, timeSlot, room.getRoomNumber());
                    bookings.add(booking);
                    bookingNotifier.notifyObservers(booking, "Забронирована");
                }
                break;
            }
        }
    }

    public void cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == bookingId) {
                bookings.remove(booking);
                bookingNotifier.notifyObservers(booking,"Свободна");
                break;
            }
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAmenities().containsAll(requiredAmenities)) {
                boolean roomOpen = true;
                for (Booking booking : bookings) {
                    if (booking.getDate().equals(date) && booking.getTimeSlot().equals(timeSlot)) {
                        roomOpen = false;
                        break;
                    }
                }
                if (roomOpen) {
                    roomList.add(room);
                }
            }
        }
        return roomList;
    }

    public void findBookingsForDate(String date) {
        List<Booking> bookingDate = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                bookingDate.add(booking);
            }
        }
    }
}

