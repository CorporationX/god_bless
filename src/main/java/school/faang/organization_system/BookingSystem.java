package school.faang.organization_system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingSystem {
    private Set<Room> rooms = new HashSet<>();
    private List<Bookingld> bookings = new ArrayList<>();

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
                for (Bookingld bookingld : bookings) {
                    if (bookingld.getRoom() == room && bookingld.getDate().equals(date) && bookingld.getTimeSlot().equals(timeSlot)) {
                        openTimeSlot = false;
                        break;
                    }
                }
                if (openTimeSlot) {
                    bookings.add(new Bookingld(room, date, timeSlot, room.getRoomNumber()));
                }
                break;
            }
        }
    }

    public void cancelBooking(int bookingId) {
        for (Bookingld booking : bookings) {
            if (booking.getRoom().getRoomNumber() == bookingId) {
                bookings.remove(booking);
                break;
            }
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAmenities().containsAll(requiredAmenities)) {
                boolean roomOpen = true;
                for (Bookingld bookingld : bookings) {
                    if (bookingld.getDate().equals(date) && bookingld.getTimeSlot().equals(timeSlot)) {
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
        List<Bookingld> bookingldDate = new ArrayList<>();
        for (Bookingld bookingld : bookings) {
            if (bookingld.getDate().equals(date)) {
                bookingldDate.add(bookingld);
            }
        }
    }
}

