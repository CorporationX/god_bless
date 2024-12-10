package school.faang.task_44715;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
    private final List<Room> rooms = new ArrayList<Room>();
    private final List<Booking> bookings = new ArrayList<Booking>();
    private final BookingNotifier notifier = new BookingNotifier();

    public void addRoom(@NonNull Room room) {
        if (rooms.stream().noneMatch(currRoom -> currRoom.equals(room))) {
            rooms.add(room);
        } else {
            System.out.println("Комната уже существует!");
        }
    }

    public void removeRoom(int roomId) {
        rooms.removeIf(room -> room.roomId() == roomId);
    }

    public boolean isAviableBooking(int roomId, String date, String timeSlot) {
        boolean isAviable = bookings.stream()
                .filter(booking -> booking.room().roomId() == roomId)
                .filter(booking -> booking.date().equals(date))
                .noneMatch(booking -> booking.timeSlot().equals(timeSlot));
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
            notifier.notifyObservers(booking, "bookingSuccess");
        } else {
            System.out.println("Бронирование не возможно!");
        }
    }

    public void cancelBooking(int bookingId) {
        Booking bookingToRemove = bookings.stream()
                .filter(booking -> booking.bookingId() == bookingId)
                .findFirst()
                .orElse(null);

        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            notifier.notifyObservers(bookingToRemove, "booking canceled");
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return rooms.stream()
                .filter(room -> bookings.stream()
                        .filter(booking -> booking.room().roomId() == room.roomId())
                        .noneMatch(booking -> booking.date().equals(date) && booking.timeSlot().equals(timeSlot))
                )
                .filter(room -> room.amenities().containsAll(requiredAmenities))
                .collect(Collectors.toList());
    }
}
