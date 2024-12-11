package school.faang.moduleone.task_43514;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static school.faang.moduleone.task_43514.BookingStatus.BOOKING_CANCELED;
import static school.faang.moduleone.task_43514.BookingStatus.BOOKING_CREATED;

@AllArgsConstructor
public class BookingSystem {
    private final Set<Room> rooms;
    private final List<Booking> bookings;
    private final BookingNotifier bookingNotifier;

    private int bookingId;

    /**
     * Метод добавления комнаты в коллекцию комнат
     *
     * @return возвращает roomId при успешном добавлении комнаты, выбрасывает
     * IllegalArgumentException добавление (регистрация) комнаты не состоялось.
     */
    public int addRoom(Room room) {
        if (rooms.add(room)) {
            return room.getRoomId();
        } else {
            throw new IllegalArgumentException(String.format(
                    "Комната с параметрами %s уже зарегистрирована!", room.toString()));
        }
    }

    public int getCountOfRegisteredRooms() {
        return rooms.size();
    }

    public int getCountOfBookings() {
        return bookings.size();
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
        Room room = getRoomById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Не найдена комната с id = " + roomId));
        if (isTimeSlotAlreadyBooked(roomId, date, timeSlot)) {
            throw new IllegalArgumentException(String.format(
                    "Таймслот %s для комнаты %d уже забронирован", timeSlot, roomId));
        }
        int bookingId = getNextBookingId();

        Booking newBooking = new Booking(bookingId, room, date, timeSlot);
        bookings.add(newBooking);
        bookingNotifier.notifyObservers(newBooking, BOOKING_CREATED.getLabel());

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
                bookingNotifier.notifyObservers(booking, BOOKING_CANCELED.getLabel());
                return true;
            }
        }
        return false;
    }

    public List<Booking> findBookingsForDate(String date) {
        return bookings.stream()
                .filter(booking -> booking.getDate().equals(date))
                .toList();
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
