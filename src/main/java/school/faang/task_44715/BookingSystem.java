package school.faang.task_44715;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Room> rooms = new ArrayList<Room>();
    private List<Booking> bookings = new ArrayList<Booking>();

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.getRoomId() == roomId);
    }

    public void bookRoom(int roomId, String date, String timeSlot) {

    }

    public void cancelBooking(int bookingId) {

    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {

    }
}
