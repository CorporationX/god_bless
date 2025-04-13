package hotels;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
    private List<Room> rooms;
    private List<Booking> bookings;

    private int bookingId = 0;

    public void addRoom(Room newRoom) {
        if (!rooms.contains(newRoom)) {
            rooms.add(newRoom);
        } else {
            System.out.println("Room already exists");
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getAmenities() == requiredAmenities) {
                for (Booking booking : bookings) {
                    if (booking.getDate() != date && booking.getTimeSlot() != timeSlot && booking.getRoom() == room) {
                        freeRooms.add(room);
                    }
                }
            } else {
                System.out.println("No rooms found");
            }
        }


        return freeRooms;
    }

    public void bookRooms(int roomNumber, String date, String timeSlot) {
        Room room = rooms.get(roomNumber);

        List<Booking> bookingForRoom;
        bookingForRoom = new ArrayList<>(bookings.stream().filter(booking
                -> booking.getRoom().getRoomNumber().equals(roomNumber)).toList());

        if (bookingForRoom.isEmpty()) {
            bookingForRoom.add(new Booking(roomNumber, date, timeSlot));
        }

        for (Booking booking : bookingForRoom) {
            if (!booking.getDate().equals(date) && !booking.getTimeSlot().equals(timeSlot)) {
                bookingId++;
                bookingForRoom.add(new Booking(roomNumber, date, timeSlot));
            }
        }
    }



}
