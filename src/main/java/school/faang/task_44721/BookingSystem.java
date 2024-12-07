package school.faang.task_44721;

import school.faang.task_44721.enums.Amenities;
import school.faang.task_44721.enums.BookingStatus;
import school.faang.task_44721.model.Booking;
import school.faang.task_44721.model.Room;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
    private final Set<Room> rooms = new HashSet<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();
    private final BookingNotifier bookingNotifier;

    private int bookingIndex = 0;

    public BookingSystem(BookingNotifier bookingNotifier) {
        this.bookingNotifier = bookingNotifier;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.getId() == roomId);

        bookings.values().stream()
                .filter(b -> b.room().getId() == roomId)
                .findFirst()
                .ifPresent(booking -> cancelBooking(booking.id()));
    }

    public void bookRoom(int roomId, LocalDateTime dateTime) {
        Room room = findRoom(roomId);

        if (room != null && room.isAvailable()) {
            Booking booking = new Booking(bookingIndex++, room, dateTime);
            bookings.put(booking.id(), booking);
            room.setAvailable(false);
            bookingNotifier.notifyObservers(booking, BookingStatus.CREATED);
        }
    }

    public void cancelBooking(int bookingId) {
        if (bookings.containsKey(bookingId)) {
            Booking book = bookings.remove(bookingId);
            book.room().setAvailable(true);
            bookingNotifier.notifyObservers(book, BookingStatus.CANCELLED);
        }
    }

    public Set<Room> findAvailableRooms(Set<Amenities> requiredAmenities) {
        return rooms.stream()
                .filter(room ->
                        room.isAvailable()
                                && room.getAmenities().containsAll(requiredAmenities)
                                && bookings.values().stream().noneMatch(b -> b.room().equals(room)))
                .collect(Collectors.toSet());
    }

    private Room findRoom(int roomId) {
        return rooms.stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElse(null);
    }
}
