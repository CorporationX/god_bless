package school.faang.task_44808.booking.domain.system;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.booking.domain.enumeration.BookingStatus;
import school.faang.task_44808.booking.domain.model.Booking;
import school.faang.task_44808.booking.domain.model.BookingFactory;
import school.faang.task_44808.booking.domain.observer.BookingNotifier;
import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.room.domain.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class BookingSystem {
    @Getter
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    @Getter
    private final BookingNotifier notifier = new BookingNotifier();
    private final BookingFactory bookingFactory;

    public BookingSystem(BookingFactory bookingFactory) {
        this.bookingFactory = bookingFactory;
    }

    public boolean bookRoom(int roomId, String date, String timeSlot) {
        Room room = findRoomById(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }

        boolean isAvailable = bookings.stream()
                .noneMatch(b -> b.getRoom().getId() == roomId
                        && b.getDate().toString().equals(date)
                        && b.getTimeSlot().timeSlot().equals(timeSlot));

        if (isAvailable) {
            Booking booking = bookingFactory.createBooking(room, new BookingDate(date), new BookingTime(timeSlot));
            bookings.add(booking);
            notifier.notifyObservers(booking, BookingStatus.BOOKED);
            log.info("Room booked successfully: roomId={}, date={}, timeSlot={}", roomId, date, timeSlot);
            return true;
        }

        log.warn("Room not available for booking: roomId={}, date={}, timeSlot={}", roomId, date, timeSlot);
        return false;
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.stream()
                .filter(b -> b.getId() == bookingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Booking with ID not found: " + bookingId));

        bookings.remove(booking);
        notifier.notifyObservers(booking, BookingStatus.CANCELLED);
        log.info("Booking canceled: bookingId={}", bookingId);
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        BookingDate bookingDate = new BookingDate(date);
        BookingTime bookingTime = new BookingTime(timeSlot);

        Set<Room> bookedRooms = bookings.stream()
                .filter(b -> b.getDate().equals(bookingDate) && b.getTimeSlot().equals(bookingTime))
                .map(Booking::getRoom)
                .collect(Collectors.toSet());

        return rooms.stream()
                .filter(room -> {
                    boolean isNotBooked = !bookedRooms.contains(room);

                    // Преобразование requiredAmenities в тип RoomAmenity
                    boolean hasAmenities = requiredAmenities.stream()
                            .allMatch(amenity -> room.getAmenities().stream()
                                    .anyMatch(roomAmenity -> roomAmenity.toString().equalsIgnoreCase(amenity)));

                    return isNotBooked && hasAmenities;
                })
                .collect(Collectors.toList());
    }

    public List<Booking> findBookingsForDate(String date) {
        BookingDate bookingDate;
        try {
            bookingDate = new BookingDate(date); // Создание объекта BookingDate для проверки формата
        } catch (IllegalArgumentException e) {
            log.error("Invalid date format: {}", date, e);
            throw e;
        }

        return bookings.stream()
                .filter(booking -> booking.getDate().equals(bookingDate))
                .collect(Collectors.toList());
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public void removeRoom(int roomId) {
        Room room = rooms.stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomId));

        bookings.removeIf(b -> b.getRoom().equals(room));
        rooms.remove(room);
        log.info("Room removed: roomId={}", roomId);
    }

    private Room findRoomById(int roomId) {
        return rooms.stream()
                .filter(r -> r.getId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomId));
    }
}