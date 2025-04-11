package school.faang.bjs2_68833;

import java.util.HashSet;
import java.util.Set;

import static school.faang.bjs2_68833.BookingIdCounter.getNextBookingId;
import static school.faang.bjs2_68833.BookingStatus.CREATED;
import static school.faang.bjs2_68833.BookingStatus.DELETED;

public class BookingSystem {
    private final Set<Room> rooms = new HashSet<>();
    private final Set<Booking> bookings = new HashSet<>();
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public void addRoom(Room room) {
        if (room == null) {
            throw new NullPointerException();
        }
        if (this.rooms.contains(room)) {
            throw new RoomAlreadyExistsException("Room with number " + room.roomNumber() + " already exists");
        }
        this.rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        rooms.remove(findRoomByNumber(roomNumber));
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        if (date == null || timeSlot == null) {
            throw new NullPointerException();
        }
        Room currentRoom = findRoomByNumber(roomNumber);
        if (!checkBookingRoom(currentRoom, date, timeSlot)) {
            throw new RoomAlreadyBookedException("Room with number " + roomNumber + " already booked");
        }
        Booking newBooking = new Booking(getNextBookingId(), currentRoom, date, timeSlot);
        this.bookings.add(newBooking);
        this.bookingNotifier.notifyObserver(newBooking, CREATED);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = findBookingById(bookingId);
        this.bookings.remove(booking);
        this.bookingNotifier.notifyObserver(booking, DELETED);
    }

    public Set<Room> findAvailableRooms(String date, String timeSlot, Set<String> amenities) {
        if (date == null || timeSlot == null || amenities == null) {
            throw new NullPointerException();
        }
        Set<Room> availableRooms = new HashSet<>();
        for (Room room : this.rooms) {
            if (isRoomAvailable(room, date, timeSlot) && room.amenities().containsAll(amenities)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Set<Booking> findBookingsForDate(String date) {
        Set<Booking> bookingsForDate = new HashSet<>();
        for (Booking booking : this.bookings) {
            if (booking.date().equals(date)) {
                bookingsForDate.add(booking);
            }
        }
        return bookingsForDate;
    }

    private Room findRoomByNumber(int roomNumber) {
        Room currentRoom = null;
        for (Room room : this.rooms) {
            if (room.roomNumber() == roomNumber) {
                currentRoom = room;
                break;
            }
        }
        if (currentRoom == null) {
            throw new RoomNotFoundException("Room with number " + roomNumber + " not found");
        }
        return currentRoom;
    }

    private Booking findBookingById(int bookingId) {
        Booking currentBooking = null;
        for (Booking booking : this.bookings) {
            if (booking.bookingId() == bookingId) {
                currentBooking = booking;
                break;
            }
        }
        if (currentBooking == null) {
            throw new BookingNotFoundException("Booking with id " + bookingId + " not found");
        }
        return currentBooking;
    }

    private boolean checkBookingRoom(Room room, String date, String timeSlot) {
        for (Booking booking : this.bookings) {
            if (booking.room().equals(room) && booking.date().equals(date) && booking.timeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        for (Booking booking : this.bookings) {
            if (booking.room().equals(room) && booking.date().equals(date) && booking.timeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
}
