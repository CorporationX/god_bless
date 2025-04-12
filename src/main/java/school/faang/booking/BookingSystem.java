package school.faang.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BookingSystem {
    private final Map<Integer, Room> dbRoom = new HashMap<>();
    private final List<Booking> dbBooking = new ArrayList<>();
    private final BookingNotifier notifier = new BookingNotifier();

    public void addRoom(Room room) {
        dbRoom.put(room.getRoomNumber(), room);
    }

    public void removeRoom(int roomNumber) {
        for (Booking booking : dbBooking) {
            if (booking.getRoom().getRoomNumber() == roomNumber) {
                notifier.notifyObservers(booking, BookingNotifier.STATUS_CANCELLED_DUE_TO_ROOM_REMOVAL);
            }
        }
        dbRoom.remove(roomNumber);
    }

    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        Room room = findRoomByNumber(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Комната с номером %d не найдена", roomNumber)));

        if (isRoomBooked(roomNumber, date, timeSlot)) {
            throw new IllegalStateException(
                    String.format("Комната с номером %d уже забронирована на это время", roomNumber));
        }

        Booking booking = new Booking(room, date, timeSlot);
        dbBooking.add(booking);
        notifier.notifyObservers(booking, BookingNotifier.STATUS_BOOKED);
        return booking;
    }

    private Optional<Room> findRoomByNumber(int roomNumber) {
        return Optional.ofNullable(dbRoom.get(roomNumber));
    }

    private boolean isRoomBooked(int roomNumber, String date, String timeSlot) {
        for (Booking booking : dbBooking) {
            if (booking.getRoom().getRoomNumber() == roomNumber
                    && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                return true;
            }
        }
        return false;
    }

    public void cancelBooking(int bookingId) {
        Booking booking = findBookingById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Брониорвание id=%d не найдено", bookingId)));
        dbBooking.remove(booking);
        notifier.notifyObservers(booking, BookingNotifier.STATUS_CANCELLED);
    }

    private Optional<Booking> findBookingById(int bookingId) {
        for (Booking booking : dbBooking) {
            if (booking.getBookingId() == bookingId) {
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Map.Entry<Integer, Room> entry : dbRoom.entrySet()) {
            Room room = entry.getValue();
            if (room.getAmenities().containsAll(requiredAmenities)) {
                if (!isRoomBooked(room.getRoomNumber(), date, timeSlot)) {
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : dbBooking) {
            if (booking.getDate().equals(date)) {
                result.add(booking);
            }
        }
        return result;
    }


    public void addObserver(BookingObserver observer) {
        notifier.addObserver(observer);
    }

    public void removeObserver(BookingObserver observer) {
        notifier.removeObserver(observer);
    }
}
