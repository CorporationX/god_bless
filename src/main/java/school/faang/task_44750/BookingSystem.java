package school.faang.task_44750;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class BookingSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    @Getter
    private final BookingNotifier notifier = new BookingNotifier();
    private int bookingCounter = 1;

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.getRoomId() == roomId);
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.stream()
                .filter(r -> r.getRoomId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Комната не найдена"));

        boolean isAvailable = bookings.stream()
                .noneMatch(b -> b.getRoom().getRoomId() == roomId && b.getDate().equals(date) && b.getTimeSlot().equals(timeSlot));

        if (!isAvailable) {
            throw new IllegalStateException("Номер уже бронирован");
        }

        Booking booking = new Booking(bookingCounter++, room, date, timeSlot);
        bookings.add(booking);
        notifier.notifyObservers(booking, " бронирован");
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Бронь не найден"));

        bookings.remove(booking);
        notifier.notifyObservers(booking, " отменен");
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.stream()
                .filter(room -> bookings.stream()
                        .noneMatch(b -> b.getRoom().getRoomId() == room.getRoomId()
                                && b.getDate().equals(date)
                                && b.getTimeSlot().equals(timeSlot)))
                .filter(room -> room.getAmenities().containsAll(requiredAmenities))
                .collect(Collectors.toList());
    }


    public List<Booking> findBookingsForDate(String date) {
        return bookings.stream()
                .filter(b -> b.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
