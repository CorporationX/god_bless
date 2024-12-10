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

    public boolean isAviableBooking(int roomId, String date, String timeSlot) {
        boolean isAviable = bookings.stream()
                .filter(booking -> booking.room().roomId() == roomId)
                .filter(booking -> booking.date() == date)
                .noneMatch(booking -> booking.timeSlot() == timeSlot);
        return isAviable;
    }

    public void bookRoom(int roomId, String date, String timeSlot) {
        Room room = rooms.stream()
                .filter(currentRoom -> currentRoom.roomId() == roomId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Комната с Id: " + roomId + " не найдена!"));

        if (isAviableBooking(roomId, date, timeSlot)) {
            Booking booking = new Booking(
                    bookings.stream().mapToInt(Booking::bookingId)
                            .max()
                            .orElse(0) + 1,
                    room, date, timeSlot
                    );
            bookings.add(booking);
        }
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> booking.bookingId() == bookingId);
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        Room room = rooms.stream()
                
    }
}
