package school.faang.bjs244733;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookingSystem {

    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Booking> poolBooking = new HashMap<>();

    private int countBookingId;

    private int countRoomId;

    @NonNull
    private final BookingNotifier bookingNotifier;

    public void addRoom(@NonNull Room room) {
        if (!rooms.containsKey(room.getRoomId())) {
            rooms.put(room.getRoomId(), room);
        } else {
            throw new UnsupportedOperationException("Комната с ID " + room.getRoomId() + " уже добавлена.");
        }
    }

    public void removeRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            rooms.remove(roomId); // Удаляем комнату, если она существует
            System.out.println("Комната с ID " + roomId + " успешно удалена.");
        } else {
            System.out.println("Комната с ID " + roomId + " не найдена.");
        }
    }

    public Booking bookRoom(int roomId, String date, String timeSlot) {

        Room room = rooms.get(roomId);

        if (room == null || !isRoomAvailable(room, date, timeSlot)) {
            return null;
        }

        Booking booking = new Booking(countBookingId++, room, date, timeSlot);
        poolBooking.put(booking.getBookingId(), booking);
        bookingNotifier.notifyObservers(booking, Status.RESERVED);
        return booking;
    }

    private boolean isRoomAvailable(Room room, String date, String timeSlot) {
        for (Booking booking : poolBooking.values()) {
            if (booking.getRoom().equals(room) && booking.getDate().equals(date)
                    && booking.getTimeSlot().equals(timeSlot)) {
                System.out.println("It is not possible to book!!!");
                return false;
            }
        }
        return true;
    }

    public boolean cancelBooking(int bookingId) {
        Booking booking = poolBooking.remove(bookingId);
        if (booking != null) {
            bookingNotifier.notifyObservers(booking, Status.AVAILABLE);
            return true;
        }
        return false;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();

        rooms.values().forEach(room -> {
            if (isRoomAvailable(room, date, timeSlot) && room.getAmenities().containsAll(requiredAmenities)) {
                availableRooms.add(room);
            }
        });
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        return poolBooking.values()
                .stream()
                .filter(b -> b.getDate().equals(date))
                .toList();
    }
}
