package school.faang.bjs2_79723_booking_system.booking;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_79723_booking_system.Util;
import school.faang.bjs2_79723_booking_system.room.Room;
import school.faang.bjs2_79723_booking_system.room.RoomAmenity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class BookingSystem {
    private final Map<Integer, Room> roomRegistry = new HashMap<>();
    private final Map<Integer, Booking> bookingRegistry = new HashMap<>();
    private final Map<Integer, List<Booking>> roomToBookingRegistry = new HashMap<>();
    private int lastBookingNumber = 0;
    private final BookingNotifier bookingNotifier = new BookingNotifier();

    public boolean addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Cannot add null room to registry.");
        }
        if (roomRegistry.containsKey(room.getRoomNumber())) {
            log.info("Attempt to add duplicate room to registry. Room number: {}", room.getRoomNumber());
            return false;
        }

        roomRegistry.put(room.getRoomNumber(), room);
        return true;
    }

    public Room getRegisteredRoomByNumber(int roomNumber) {
        return roomRegistry.get(roomNumber);
    }

    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot add booking with empty date or timeslot.");
        }
        if (!roomRegistry.containsKey(roomNumber)) {
            log.warn("Attempt to add booking to a non registered room.");
            return null;
            // If i want to return Booking object,
            // should i return null here or throw an exception and handle in caller method?
        }

        if (isRoomAvailable(roomNumber, date, timeSlot)) {
            Booking newBooking = createBooking(roomRegistry.get(roomNumber), date, timeSlot);
            bookingNotifier.notifyObservers(newBooking, BookingStatus.CREATED);
            return newBooking;
        }

        log.info("Could not add booking, room unavailable");
        return null;
    }

    private Booking createBooking(Room room, String date, String timeSlot) {
        if (room == null) {
            throw new IllegalArgumentException("Cannot create booking for null room.");
        }
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot create booking for empty date or time");
        }

        Booking newBooking = new Booking(getNewBookingNumber(), room, date, timeSlot);
        bookingRegistry.put(newBooking.getBookingId(), newBooking);
        roomToBookingRegistry.computeIfAbsent(
                newBooking.getRoom().getRoomNumber(),
                k -> new ArrayList<>()
        ).add(newBooking);
        log.info("New booking added: {}", newBooking);
        return newBooking;
    }

    private boolean isRoomAvailable(int roomNumber, String date, String timeSlot) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            log.warn("Cannot add check availability for empty date or timeslot.");
            return false;
        }
        if (roomToBookingRegistry.get(roomNumber) == null || roomToBookingRegistry.get(roomNumber).isEmpty()) {
            return true;
        }

        for (Booking booking : roomToBookingRegistry.get(roomNumber)) {
            if (isSameDateAndTimeslot(booking, date, timeSlot)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSameDateAndTimeslot(Booking booking, String date, String timeSlot) {
        return booking.getDate().equals(date) && booking.getTimeslot().equals(timeSlot);
    }

    private int getNewBookingNumber() {
        return lastBookingNumber++;
    }

    public boolean removeRoom(int roomNumber) {
        Room removedRoom = roomRegistry.remove(roomNumber);
        if (removedRoom != null) {
            List<Booking> bookingsNeedCancelling = new ArrayList<>(roomToBookingRegistry.get(roomNumber));
            bookingsNeedCancelling.forEach(booking -> cancelBooking(booking.getBookingId()));
            roomToBookingRegistry.remove(roomNumber);
            log.info("Removed room {} from registry.", removedRoom);
            return true;
        }
        log.warn("Could not remove room from registry. Room nr: {} not found.", roomNumber);
        return false;
    }

    private void cancelBooking(int bookingId) {
        Booking booking = bookingRegistry.get(bookingId);
        if (booking != null) {
            roomToBookingRegistry.get(booking.getRoom().getRoomNumber()).remove(booking);
            bookingNotifier.notifyObservers(booking, BookingStatus.CANCELLED);
            bookingRegistry.remove(bookingId);
            log.info("Cancelled booking {}.", bookingId);
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<RoomAmenity> requiredAmenities) {
        if (Util.isEmptyValueString(date) || Util.isEmptyValueString(timeSlot)) {
            throw new IllegalArgumentException("Cannot find available rooms. Date and timeslot must be provided.");
        }
        HashMap<Integer, Room> availableRoomsByNumber = new HashMap<>(roomRegistry);
        bookingRegistry.forEach((integer, booking) -> {
            if (isSameDateAndTimeslot(booking, date, timeSlot)) {
                availableRoomsByNumber.remove(booking.getRoom().getRoomNumber());
            }
        });
        return filterRoomsByAmenities(new ArrayList<>(availableRoomsByNumber.values()), requiredAmenities);
    }

    private List<Room> filterRoomsByAmenities(List<Room> rooms, Set<RoomAmenity> requiredAmenities) {
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