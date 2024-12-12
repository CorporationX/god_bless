package school.faang.task_44732;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class BookingSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final BookingNotifier notifier = new BookingNotifier();

    private static int bookingCounter = 0;

    public void addObserver(BookingObserver observer) {
        notifier.addObserver(observer);
    }

    public void removeObserver(BookingObserver observer) {
        notifier.removeObserver(observer);
    }

    public void addRoom(Room room) {
        rooms.add(room);
        log.info("Room added: {}", room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.getRoomId() == roomId);
        log.info("Room with ID {} removed", roomId);
    }

    public Booking bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.stream()
                .filter(r -> r.getRoomId() == roomId)
                .findFirst()
                .orElse(null);

        if (room == null) {
            log.warn("Room with ID {} not found", roomId);

            return null;
        }

        boolean isAvailable = bookings.stream()
                .noneMatch(b -> b.getRoom().getRoomId() == roomId
                        && b.getDate().equals(date)
                        && b.getTimeSlot().equals(timeSlot));

        if (!isAvailable) {
            log.warn("Room with ID {} is already booked at {} on {}", roomId, timeSlot, date);

            return null;
        }

        Booking newBooking = new Booking(bookingCounter++, room, date, timeSlot);
        bookings.add(newBooking);
        notifier.notifyObservers(newBooking, "BOOKED");
        log.info("Room booked: {}", newBooking);

        return newBooking;
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);

        if (booking != null) {
            bookings.remove(booking);
            notifier.notifyObservers(booking, "CANCELED");
            log.info("Booking canseled: {}", booking);
        } else {
            log.warn("Booking with ID {} not found", bookingId);
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requireAmenities) {
        return rooms.stream()
                .filter(room -> room.getAmenities().containsAll(requireAmenities))
                .filter(room -> bookings.stream().noneMatch(b ->
                        b.getRoom().getRoomId() == room.getRoomId()
                                && b.getDate().equals(date)
                                && b.getTimeSlot().equals(timeSlot)))
                .collect(Collectors.toList());
    }

    public List<Booking> findBookingForDate(String date) {
        return bookings.stream()
                .filter(b -> b.getDate().equals(date))
                .collect(Collectors.toList());
    }
}