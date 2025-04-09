package school.faang.bookingmanagement;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* Related to JIRA ticket: BJS2-68742
 * */
@NoArgsConstructor
@Getter
public class BookingSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final Set<Booking> bookings = new HashSet<>();
    private final BookingNotifier notifier = new BookingNotifier();

    private final Map<Room, Integer> listIndexByRoom = new HashMap<>();
    private final Map<Integer, Booking> bookingById = new HashMap<>();

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room was not added to the list! Room is null!");
        } else if (listIndexByRoom.containsKey(room)) {
            throw new IllegalArgumentException("Room was not added to the list! Room is already in the System!");
        }
        rooms.add(room);
        listIndexByRoom.put(room, rooms.size() - 1);
    }

    public void removeRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room was not removed! Room is null!");
        } else if (!rooms.contains(room)) {
            throw new IllegalArgumentException("Yuo are trying to delete the room that is not in the System!");
        } else if (isRoomInBooking(room)) {
            throw new IllegalStateException("Room was not removed! Room is booked!");
        }
        int roomIndex = listIndexByRoom.get(room);
        listIndexByRoom.remove(room);
        rooms.remove(roomIndex);
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        if (!listIndexByRoom.containsKey(new Room(roomNumber))) {
            throw new IllegalArgumentException(String.format("The room with number %d is not in " +
                            "the Booking System!",
                    roomNumber));
        }
        int roomListIndex = listIndexByRoom.get(new Room(roomNumber));
        Room room = rooms.get(roomListIndex);
        if (isRoomInBooking(room)) {
            throw new IllegalStateException("The room is already booked!");
        }

        Booking newbooking = new Booking(room, date, timeSlot);
        bookings.add(newbooking);
        bookingById.put(newbooking.getBookingId(), newbooking);

        notifier.notifyObservers(newbooking, "Booked successfully!");
    }

    public void cancelBooking(int bookingId) {
        if (!bookingById.containsKey(bookingId)) {
            throw new IllegalArgumentException("Booking doesn't exist!");
        }
        Booking bookingToRemove = bookingById.get(bookingId);
        bookings.remove(bookingById.get(bookingId));
        bookingById.remove(bookingId);
        notifier.notifyObservers(bookingToRemove, String.format("Booking with id: %d was removed!", bookingId));

    }

    public List<Room> findAvailableRooms(String strDate, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);

        String[] timeParts = timeSlot.split("-");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime newStart = LocalTime.parse(timeParts[0], timeFormatter);
        LocalTime newEnd = LocalTime.parse(timeParts[1], timeFormatter);

        for (Room room : rooms) {
            boolean isRoomAvailable = true;
            if (!room.getAmenities().containsAll(requiredAmenities)) {
                continue;
            }
            for (Booking booking : bookings) {
                if (!booking.getRoom().equals(room)) {
                    continue;
                }
                LocalDate bookedDate = LocalDate.parse(booking.getDate(), dateTimeFormatter);
                if (bookedDate.equals(date)) {
                    String[] bookedTimeParts = booking.getTimeSlot().split("-");
                    LocalTime bookedStart = LocalTime.parse(bookedTimeParts[0], timeFormatter);
                    LocalTime bookedEnd = LocalTime.parse(bookedTimeParts[1], timeFormatter);

                    if (newStart.isBefore(bookedEnd) && bookedStart.isBefore(newEnd)) {
                        isRoomAvailable = false;
                        break;
                    }
                }
            }
            if (isRoomAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Booking> findBookingForDate(String date) {
        List<Booking> bookingForDate = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date)) {
                bookingForDate.add(booking);
            }
        }
        return bookingForDate;
    }

    private boolean isRoomInBooking(Room room) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room)) {
                return true;
            }
        }
        return false;
    }
}
