package school.faang.bookingsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class BookingSystem {
    private static final String PRINT_ROOM_FORMAT = "Room number: {}, type: {}, amenities: {}";
    private static final String PRINT_ROOM_AVAILABLE_FORMAT = "Available rooms in date: {} and time: {}:";
    private static final String PRINT_FOR_DATE_FORMAT = "Date: {}, id: {}, time: {}";
    private static final int HOURS_TO_MINUTES = 60;
    private static final int[] START_HOUR_INTERVALS = {0, 2};
    private static final int[] END_HOUR_INTERVALS = {3, 5};
    private static final int[] START_MINUTE_INTERVALS = {6, 8};
    private static final int[] END_MINUTE_INTERVALS = {9, 11};

    private final Map<Integer, Room> roomMap = new HashMap<>();
    private final Map<Integer, Booking> bookingMap = new HashMap<>();
    private final BookingNotifier bookingNotifier;

    public BookingSystem(BookingNotifier bookingNotifier) {
        this.bookingNotifier = bookingNotifier;
    }

    public void addRoom(Room room) {
        if (!roomMap.containsKey(room.getRoomNumber())) {
            roomMap.put(room.getRoomNumber(), room);
        } else {
            log.info("{} already added to the list", room.getRoomNumber());
        }
    }

    public void removeRoom(int roomNumber) {
        if (roomMap.containsKey(roomNumber)) {
            roomMap.remove(roomNumber);
        } else {
            log.info("{} does not exist in the list", roomNumber);
        }
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        if (roomMap.containsKey(roomNumber)) {
            if (isRoomAvailable(date, timeSlot, roomNumber)) {
                Booking booking = new Booking(roomMap.get(roomNumber), date, timeSlot);
                bookingMap.put(booking.getBookingId(), booking);
                bookingNotifier.notifyObservers(booking, "Booked");
            } else {
                log.info("{} has already been booked", roomNumber);
            }
        } else {
            log.info("Room number {} does not exist", roomNumber);
        }
    }

    public void cancelBooking(int bookingId) {
        if (bookingMap.containsKey(bookingId)) {
            bookingNotifier.notifyObservers(bookingMap.get(bookingId), "Cancelled");
            bookingMap.remove(bookingId);
        } else {
            log.info("Booking {} does not exist", bookingId);
        }
    }

    public void findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        log.info(PRINT_ROOM_AVAILABLE_FORMAT, date, timeSlot);
        if (!requiredAmenities.isEmpty()) {
            roomMap.forEach((key, value) -> {
                if (value.getAmenities().containsAll(requiredAmenities)) {
                    if (isRoomAvailable(date, timeSlot, key)) {
                        printRooms(value);
                    }
                }
            });
        } else {
            throw new NullPointerException("There are no necessary amenities");
        }
    }

    private boolean isRoomAvailable(String date, String timeSlot, int roomNumber) {
        boolean isAvailable = true;
        for (Booking booking : bookingMap.values()) {
            if (isValidData(date, timeSlot, roomNumber, booking)) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }

    private boolean isValidData(String date, String timeSlot, int roomNumber, Booking booking) {
        int myTimeStart = parseTimeSlot(timeSlot, START_HOUR_INTERVALS, END_HOUR_INTERVALS);
        int myTimeEnd = parseTimeSlot(timeSlot, START_MINUTE_INTERVALS, END_MINUTE_INTERVALS);
        int bookingTimeStart = parseTimeSlot(booking.getTimeSlot(),
                START_HOUR_INTERVALS, END_HOUR_INTERVALS);
        int bookingTimeEnd = parseTimeSlot(booking.getTimeSlot(),
                START_MINUTE_INTERVALS, END_MINUTE_INTERVALS);
        return booking.getRoom().getRoomNumber() == roomNumber
                && date.equals(booking.getDate())
                && (myTimeStart < bookingTimeEnd && bookingTimeStart < myTimeEnd);
    }

    private int parseTimeSlot(String timeSlot, int[] start, int[] end) {
        return Integer.parseInt(timeSlot.substring(start[0], start[1]))
                * HOURS_TO_MINUTES + Integer.parseInt(timeSlot.substring(end[0], end[1]));
    }

    private void printRooms(Room room) {
        log.info(PRINT_ROOM_FORMAT, room.getRoomNumber(), room.getType(), room.getAmenities());
    }

    public void findBookingsForDate(String date) {
        bookingMap.forEach((key, value) -> {
            if (value.getDate().equals(date)) {
                log.info(PRINT_FOR_DATE_FORMAT, date, key, value.getTimeSlot());
                printRooms(value.getRoom());
            }
        });
    }
}
