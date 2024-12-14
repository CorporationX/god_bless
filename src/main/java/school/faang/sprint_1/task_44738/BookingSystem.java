package school.faang.sprint_1.task_44738;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingSystem {
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public void addRoom(@NonNull Room room) {
        rooms.put(room.getId(), room);
    }

    public void removeRoom(@NonNull Room room) {
        rooms.remove(room.getId());
    }

    public Booking bookRoom(int roomId, @NonNull Date dateBegin, @NonNull Date dateEnd) {
        Room room = rooms.get(roomId);

        if (room != null && isAvailable(room, dateBegin, dateEnd)) {
            Booking booking = new Booking(room, dateBegin, dateEnd);
            bookings.put(booking.getId(), booking);
            bookingNotifier.notifyObservers(booking, "created");
            return booking;
        } else {
            return null;
        }
    }

    public boolean removeBooking(int bookingId) {
        Booking remove = bookings.remove(bookingId);
        if (remove != null) {
            bookingNotifier.notifyObservers(remove, "removed");
            return true;
        } else {
            return false;
        }
    }

    public List<Room> findAvailableRooms(@NonNull Date dateBegin,
                                         @NonNull Date dateEnd,
                                         @NonNull Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            boolean haveAllRequiredAmenities = room.getAmenities().containsAll(requiredAmenities);
            if (haveAllRequiredAmenities && isAvailable(room, dateBegin, dateEnd)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private boolean isAvailable(@NonNull Room room,
                                @NonNull Date dateBegin,
                                @NonNull Date dateEnd) {
        for (Booking concurrentBooking : bookings.values()) {
            if (concurrentBooking.getRoom().equals(room)) {
                Date concurrentDateBegin = concurrentBooking.getDateBegin();
                Date concurrentDateEnd = concurrentBooking.getDateEnd();
                return !isDateBetweenAnotherDates(dateBegin, concurrentDateBegin, concurrentDateEnd)
                        || !isDateBetweenAnotherDates(dateEnd, concurrentDateBegin, concurrentDateEnd);
            }
        }
        return true;
    }

    public List<Booking> findBookingsForDate(@NonNull Date date) {
        List<Booking> bookingsForDate = new ArrayList<>();

        for (Booking booking : bookings.values()) {
            if (isDateBetweenAnotherDates(date, booking.getDateBegin(), booking.getDateEnd())) {
                bookingsForDate.add(booking);
            }
        }
        return bookingsForDate;
    }

    private boolean isDateBetweenAnotherDates(@NonNull Date dateToCheck,
                                              @NonNull Date dateBegin,
                                              @NonNull Date dateEnd) {
        return dateToCheck.after(dateBegin)
                && dateToCheck.before(dateEnd)
                || dateToCheck.equals(dateBegin)
                || dateToCheck.equals(dateEnd);
    }
}
