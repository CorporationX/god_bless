package school.faang.task_44723;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import school.faang.task_44723.model.Amenity;
import school.faang.task_44723.model.Booking;
import school.faang.task_44723.model.BookingStatus;
import school.faang.task_44723.model.Room;
import school.faang.task_44723.utils.IdGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@AllArgsConstructor
public class BookingSystem {
    private final BookingNotifier bookingNotifier;
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> bookings = new HashMap<>();

    public void addRoom(@NotNull Room room) {
        rooms.put(room.getId(), room);
    }

    public void removeRoom(int roomId) {
        rooms.remove(roomId);
    }

    public void bookRoom(
            int roomId,
            @NotNull LocalDate date,
            @NotNull LocalTime startTime,
            @NotNull LocalTime endTime
    ) {
        if (!roomIsAvailableForBooking(roomId, date, startTime, endTime)) {
            log.info(
                    "The room by id {} on the date {} and by time from {} to {} is already booked",
                    roomId,
                    date,
                    startTime,
                    endTime
            );
            return;
        }

        Room bookingRoom = rooms.get(roomId);
        Booking booking = new Booking(
                IdGenerator.generateId(),
                bookingRoom,
                date,
                startTime,
                endTime
        );
        bookings.put(booking.getId(), booking);

        bookingNotifier.notifyObservers(booking, BookingStatus.BOOKED);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.remove(bookingId);
        bookingNotifier.notifyObservers(booking, BookingStatus.CANCELLED);
    }

    public Set<Room> findAvailableRooms(
            @NotNull LocalDate date,
            @NotNull LocalTime startTime,
            @NotNull LocalTime endTime,
            Set<Amenity> requiredAmenities
    ) {
        Set<Room> availableRooms = new HashSet<>();

        for (Room room : rooms.values()) {
            Set<Booking> bookingsByRoom = findBookingsByRoom(room);

            if (bookingsByRoom.isEmpty()) {
                availableRooms.add(room);
                continue;
            }

            bookingsByRoom.forEach(booking -> {

                Room bookedRoom = booking.getRoom();
                LocalDate bookedDate = booking.getDate();
                LocalTime bookedStartTime = booking.getStartTime();
                LocalTime bookedEndTime = booking.getEndTime();

                boolean containsAmenities = bookedRoom.getAmenities().containsAll(requiredAmenities);

                if (containsAmenities
                        && !bookedDate.equals(date)
                        && !timeIsBooked(startTime, endTime, bookedStartTime, bookedEndTime)
                ) {
                    availableRooms.add(room);
                }
            });
        }

        return availableRooms;
    }

    public Set<Booking> findBookingsForDate(LocalDate date) {
        Set<Booking> bookingsForDate = new HashSet<>();
        bookings.forEach((bookingId, booking) -> {
            if (booking.getDate().equals(date)) {
                bookingsForDate.add(booking);
            }
        });
        return bookingsForDate;
    }

    public Set<Booking> findBookingsByRoom(Room room) {
        Set<Booking> bookingsByRoom = new HashSet<>();
        bookings.forEach((bookingId, booking) -> {
            if (booking.getRoom().equals(room)) {
                bookingsByRoom.add(booking);
            }
        });
        return bookingsByRoom;
    }

    private boolean roomIsAvailableForBooking(
            int roomId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    ) {
        for (Booking booking : bookings.values()) {

            Room bookedRoom = booking.getRoom();

            LocalDate bookedDate = booking.getDate();
            LocalTime bookedStartTime = booking.getStartTime();
            LocalTime bookedEndTime = booking.getEndTime();

            if (bookedRoom.getId() == roomId && bookedDate.equals(date)
                    && timeIsBooked(startTime, endTime, bookedStartTime, bookedEndTime)
            ) {
                return false;
            }
        }

        return true;
    }

    private boolean timeIsBooked(
            LocalTime startTime,
            LocalTime endTime,
            LocalTime bookedStartTime,
            LocalTime bookedEndTime
    ) {
        return (startTime.isBefore(bookedEndTime) && endTime.isAfter(bookedStartTime))
                || (startTime.equals(bookedStartTime) && endTime.equals(bookedEndTime));
    }
}
