package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {
    private Map<Integer, Room> rooms = new HashMap<>();
    private List<Booking> bookings = new ArrayList<>();

    public boolean addRoom(Room room) {
        validateRoom(room);
        if (rooms.containsKey(room.getRoomNumber())) {
            return false;
        }
        rooms.put(room.getRoomNumber(), room);
        return true;
    }

    public boolean removeRoom(Room room) {
        validateRoom(room);
        if (!rooms.containsKey(room.getRoomNumber())) {
            return false;
        }
        rooms.remove(room.getRoomNumber());
        return true;
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {

    }

    private void validateRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("The room can't be null or blank");
        }
    }
}
