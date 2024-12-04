package school.faang.task_43514;

import school.faang.task_43514.enums.Amenities;
import school.faang.task_43514.model.Booking;
import school.faang.task_43514.model.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
    Set<Room> rooms = new HashSet<>();
    List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public void bookRoom(Room room, LocalDateTime dateTime) {

    }

    public void cancelBooking(int bookingId) {

    }

    public Set<Room> findAvailableRooms(LocalDateTime dateTime, Set<Amenities> requiredAmenities) {
        return bookings.stream()
                .filter(b -> b.getDateTimeSlot().isEqual(dateTime))
                .map(Booking::getRoom)
                .filter(room -> room.getAmenities().containsAll(requiredAmenities))
                .collect(Collectors.toSet());
    }
}
