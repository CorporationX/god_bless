package school.faang.bookingsystem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class BookingSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private BookingNotifier notifier = new BookingNotifier();
    private int bookingCounter = 1;

    public void addRoom(Room room) {
        if (room == null) {
            System.out.println("Комната не может быть null.");
            return;
        }

        if (rooms.contains(room)) {
            System.out.println("Эта комната уже есть в списке: " + room.toString());
            return;
        }

        rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        if (roomNumber < 0) {
            System.out.println("Номер комнаты не может быть отрицательным.");
        }

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                rooms.remove(room);
                return;
            }
        }
    }

    public boolean bookRoom(int roomNumber, String date, String timeSlot) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                Booking booking = new Booking(bookingCounter++, room, date, timeSlot);
                bookings.add(booking);
                notifier.notifyObservers(booking, "Забронировано!");
                return true;
            }
        }
        return false;
    }

    public boolean cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                notifier.notifyObservers(booking, "Бронирование отменено!");
                return true;
            }
        }
        return false;
    }

    public List<Room> findAvailableRooms(String date, String timeSlot,
                                         Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean isAvailable = true;
            for (Booking booking : bookings) {
                if (
                        booking.getRoom().getRoomNumber() == room.getRoomNumber()
                        && booking.getDate().equals(date)
                        && booking.getTimeSlot().equals(timeSlot)
                ) {
                    isAvailable = false;
                }
            }
            boolean hasAmenities = room.getAmenities().containsAll(requiredAmenities);
            if (isAvailable && hasAmenities) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
