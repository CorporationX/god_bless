package school.faang.moduleone.task_43514;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class BookingSystem {
    private final Set<Room> rooms;
    private final List<Booking> bookings;
    private final BookingNotifier bookingNotifier;

    private int bookingId;

    public BookingSystem() {
        this.rooms = new HashSet<>();
        this.bookings = new ArrayList<>();
        this.bookingNotifier = new BookingNotifier();
    }

    /**
     * Метод добавления комнаты в коллекцию комнат
     *
     * @return возвращает roomId при успешном добавлении комнаты,
     * и -1 если добавление не состоялось
     */
    public int addRoom(Room room) {
        if (rooms.add(room)) {
            return room.getRoomId();
        }
        return -1;
    }

    public boolean removeRoom(int roomId) {
        Room roomForDeletion = null;
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                roomForDeletion = room;
                break;
            }
        }
        if (roomForDeletion != null) {
            return rooms.remove(roomForDeletion);
        }
        return false;
    }

    /**
     * Метод бронирует комнату на указанную дату и временной интервал, если она доступна.
     * При успешном бронировании уведомляет всех наблюдателей.
     *
     * @return при успешном бронировании возвращает int bookingId, при неуспешном -1
     */
    public int bookRoom(int roomId, String date, String timeSlot) {
        Room room;
        var roomOpt = getRoomById(roomId);
        if (roomOpt.isPresent()) {
            room = roomOpt.get();
        } else {
            return -1;
        }
        if (isTimeSlotAlreadyBooked(roomId, date, timeSlot)) {
            return -1;
        }
        int bookingId = getNextBookingId();

        Booking newBooking = new Booking(bookingId, room, date, timeSlot);
        bookings.add(newBooking);
        bookingNotifier.notifyObservers(newBooking, "BOOKING_CREATED");

        return bookingId;
    }

    /**
     * Метод отменяет бронирование и уведомляет всех наблюдателей.
     */
    public boolean cancelBooking(int bookingId) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBookingId() == bookingId) {
                iterator.remove();
                bookingNotifier.notifyObservers(booking, "BOOKING_CANCELED");
                return true;
            }
        }
        return false;
    }

    public List<Booking> findBookingsForDate(String date) {
        return bookings.stream()
                .filter(booking -> booking.getDate().equals(date))
                .collect(Collectors.toList());
    }

    private int getNextBookingId() {
        return ++bookingId;
    }

    private boolean isTimeSlotAlreadyBooked(int roomId, String date, String timeSlot) {
        List<String> bookedTimeSlots = new ArrayList<>();
        for (Booking booking : bookings) {
            if ((booking.getRoom().getRoomId() == roomId) && (booking.getDate().equals(date))) {
                bookedTimeSlots.add(booking.getTimeSlot());
            }
        }
        return bookedTimeSlots.contains(timeSlot);
    }

    private Optional<Room> getRoomById(int roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId() == roomId)
                .findFirst();
    }
}
