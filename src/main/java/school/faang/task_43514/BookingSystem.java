package school.faang.task_43514;

import school.faang.task_43514.enums.Amenities;
import school.faang.task_43514.enums.BookingStatus;
import school.faang.task_43514.model.Booking;
import school.faang.task_43514.model.Room;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
    private final Set<Room> rooms = new HashSet<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();

    private int bookingIndex = 0;

    private final BookingNotifier bookingNotifier;

    public BookingSystem(BookingNotifier bookingNotifier) {
        this.bookingNotifier = bookingNotifier;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        Room room = findRoom(roomId);

        if (room != null) {
            rooms.remove(room);

            bookings.values().stream()
                    .filter(b -> b.getRoom().getId() == roomId)
                    .findFirst()
                    .ifPresent(booking -> cancelBooking(booking.getId()));

        }
    }

    public void bookRoom(int roomId, LocalDateTime dateTime) {
        Room room = findRoom(roomId);

        if (room != null && room.isAvailable()) {
            Booking booking = new Booking(bookingIndex++, room, dateTime);
            bookings.put(booking.getId(), booking);
            room.setAvailable(false);
            bookingNotifier.notifyObservers(booking, BookingStatus.CREATED);
        }
    }

    public void cancelBooking(int bookingId) {
        if (bookings.containsKey(bookingId)) {
            Booking book = bookings.remove(bookingId);
            bookingNotifier.notifyObservers(book, BookingStatus.CANCELLED);
        }
    }

    public Set<Room> findAvailableRooms(LocalDateTime dateTime, Set<Amenities> requiredAmenities) {
        return bookings.values().stream()
                .filter(b -> b.getDateTimeSlot().isEqual(dateTime) == false)
                .map(Booking::getRoom)
                .filter(room -> room.getAmenities().containsAll(requiredAmenities) && room.isAvailable())
                .collect(Collectors.toSet());
    }

    private Room findRoom(int roomId) {
        return rooms.stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElse(null);
    }
}
