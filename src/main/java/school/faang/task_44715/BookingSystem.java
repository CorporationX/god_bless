package school.faang.task_44715;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookingSystem {
    private List<Room> rooms = new ArrayList<Room>();
    private List<Booking> bookings = new ArrayList<Booking>();

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.roomId() == roomId);
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.stream()
                .filter(currentRoom -> currentRoom.roomId() == roomId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Комната с Id: " + roomId + " не найдена!"));

        Booking booking = new Booking(
                bookings.stream().mapToInt(Booking::bookingId)
                        .max()
                        .orElse(0) + 1,
                room,
                date,
                bookings.stream().filter(currBooking -> currBooking.date() == date).map(Booking::timeSlot).
        );
        bookings.add(booking);
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> booking.bookingId() == bookingId);
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {

    }
}
