package school.faang.bjs2_79723_booking_system;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class BookingSystem {
    private static final HashMap<Integer, Room> ROOMS = new HashMap<>();
    private static final HashMap<Integer, Booking> BOOKINGS = new HashMap<>();
    private static final Map<Integer, List<Booking>> ROOM_TO_BOOKINGS = new HashMap<>();
    private static int lastBookingNumber = 0;

    public static Room addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Cannot add null room to registry.");
        }
        if (ROOMS.containsKey(room.getRoomNumber())) {
            log.warn("Attempt to add duplicate room to registry. Room number: {}", room.getRoomNumber());
            return room;
        }

        ROOMS.put(room.getRoomNumber(), room);
        return room;
    }

    public static boolean bookRoom(int roomNumber, String date, String timeSlot) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot add booking with empty date or timeslot.");
        }
        if (!ROOMS.containsKey(roomNumber)) {
            log.warn("Attempt to add booking to a non registered room.");
            return false;
        }

        if (isRoomAvailable(roomNumber, date, timeSlot)) {
            Booking newBooking = createBooking(ROOMS.get(roomNumber), date, timeSlot);
            BookingNotifier.notifyObservers(newBooking, Booking.STATUS_CREATED);
            return true;
        }

        log.info("Could not add booking, room unavailable");
        return false;
    }

    private static Booking createBooking(Room room, String date, String timeSlot) {
        if (room == null) {
            throw new IllegalArgumentException("Cannot create booking for null room.");
        }
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot create booking for empty date or time");
        }

        Booking newBooking = new Booking(getNewBookingNumber(), room, date, timeSlot);
        BOOKINGS.put(newBooking.getBookingId(), newBooking);
        ROOM_TO_BOOKINGS.computeIfAbsent(newBooking.getRoom().getRoomNumber(), k -> new ArrayList<>()).add(newBooking);
        log.info("New booking added: {}", newBooking);
        return newBooking;
    }

    private static boolean isRoomAvailable(int roomNumber, String date, String timeSlot) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            log.warn("Cannot add check availability for empty date or timeslot.");
            return false;
        }
        if (ROOM_TO_BOOKINGS.get(roomNumber) == null || ROOM_TO_BOOKINGS.get(roomNumber).isEmpty()) {
            return true;
        }

        for (Booking booking : ROOM_TO_BOOKINGS.get(roomNumber)) {
            if (isSameDateAndTimeslot(booking, date, timeSlot)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSameDateAndTimeslot(Booking booking, String date, String timeSlot) {
        return booking.getDate().equals(date) && booking.getTimeslot().equals(timeSlot);
    }

    private static int getNewBookingNumber() {
        return lastBookingNumber++;
    }

    public static boolean removeRoom(int roomNumber) {
        Room removedRoom = ROOMS.remove(roomNumber);
        if (removedRoom != null) {
            List<Booking> bookingsNeedCancelling = new ArrayList<>(ROOM_TO_BOOKINGS.get(roomNumber));
            bookingsNeedCancelling.forEach(booking -> cancelBooking(booking.getBookingId()));
            ROOM_TO_BOOKINGS.remove(roomNumber);
            log.info("Removed room {} from registry.", removedRoom);
            return true;
        }
        log.warn("Could not remove room from registry. Room nr: {} not found.", roomNumber);
        return false;
    }

    private static void cancelBooking(int bookingId) {
        Booking booking = BOOKINGS.get(bookingId);
        if (booking != null) {
            ROOM_TO_BOOKINGS.get(booking.getRoom().getRoomNumber()).remove(booking);
            BookingNotifier.notifyObservers(booking, Booking.STATUS_CANCELLED);
            BOOKINGS.remove(bookingId);
            log.info("Cancelled booking {}.", bookingId);
        }
    }

    public static List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot find available rooms. Date and timeslot must be provided.");
        }
        HashMap<Integer, Room> availableRoomsByNumber = new HashMap<>(ROOMS);
        BOOKINGS.forEach((integer, booking) -> {
            if (isSameDateAndTimeslot(booking, date, timeSlot)) {
                availableRoomsByNumber.remove(booking.getRoom().getRoomNumber());
            }
        });
        return filterRoomsByAmenities(new ArrayList<>(availableRoomsByNumber.values()), requiredAmenities);
    }

    private static List<Room> filterRoomsByAmenities(List<Room> rooms, Set<String> requiredAmenities) {
        if (requiredAmenities == null || requiredAmenities.isEmpty()) {
            return rooms;
        }
        List<Room> validRooms = new ArrayList<>();
        rooms.forEach(room -> {
            if (room.getAmenities() != null && room.getAmenities().containsAll(requiredAmenities)) {
                validRooms.add(room);
            }
        });
        return validRooms;
    }
}