package school.faang.stream1.bookingsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Вы работаете над системой бронирования помещений, которая должна
 * обеспечивать эффективное распределение доступных комнат и отслеживать наличие удобств в них.
 * В системе бронирования должны учитываться тип комнаты, дата, время, а также удобства, необходимые пользователю.
 * Система также должна поддерживать уведомление заинтересованных сторон (например, администратора или пользователей)
 * о бронировании или освобождении комнаты.
 */

@RequiredArgsConstructor
@Getter
public class BookingSystem {
    private final List<Booking> bookingList;
    private final List<Room> roomList;

    private final BookingNotifier bookingNotifier;

    // — добавляет комнату в систему.
    public boolean addRoom(Room room) {
        return roomList.add(room);
    }

    // — удаляет комнату из системы.
    public boolean removeRoom(int roomNumber) {
        Optional<Room> optRoom2remove = roomList
                .stream().filter(r -> (r.getRoomNumber() == roomNumber)).findFirst();
        return optRoom2remove.map(roomList::remove).orElse(false);
    }

    // — бронирует комнату на указанную дату и временной интервал, если она доступна.
    // При успешном бронировании уведомляет всех наблюдателей.
    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        List<Booking> roomBookings = bookingList.stream()
                .filter(b -> roomNumber == b.getRoom().getRoomNumber()).toList();
        if (roomBookings.isEmpty() || checkRoomAvailableForBooking(roomBookings, date, timeSlot)) {
            return createBooking(roomNumber, date, timeSlot);
        }
        return null;
    }

    // — отменяет бронирование и уведомляет всех наблюдателей.
    public Booking cancelBooking(int bookingId) {
        Optional<Booking> bookingById = BookingSystemUtil.getBookingById(bookingList, bookingId);
        if (bookingById.isPresent()) {
            Booking booking = bookingById.get();
            bookingList.remove(booking);
            bookingNotifier.notifyObservers(booking, "canceled");
        }
        return null;
    }

    // — возвращает список доступных комнат, которые подходят по дате, времени и набору удобств.
    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> rooms2Check = roomList.stream()
                .filter(r -> r.getAmenities().containsAll(requiredAmenities)).toList();
        Map<Room, List<Booking>> roomListMap = bookingList.stream()
                .filter(b -> b.getDate().equals(date))
                .filter(b -> rooms2Check.contains(b.getRoom()))
                .collect(Collectors.groupingBy(Booking::getRoom));
        List<Room> roomsDoesntPass = roomListMap.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .anyMatch(b -> BookingSystemUtil.timeSlotCrossing(b.getTimeSlot(), timeSlot)))
                .map(Map.Entry::getKey)
                .toList();

        return rooms2Check.stream().filter(r -> !roomsDoesntPass.contains(r)).toList();
    }

    //additional возвращает список всех бронирований на указанную дату.
    public List<Booking> findBookingsForDate(String date) {
        return bookingList.stream().filter(b -> (date.equals(b.getDate()))).toList();
    }

    private Booking createBooking(int roomNumber, String date, String timeSlot) {
        Optional<Room> roomByNumber = BookingSystemUtil.getRoomByNumber(roomList, roomNumber);
        if (roomByNumber.isEmpty()) {
            return null;
        }
        Booking newBooking = new Booking(roomByNumber.get(), date, timeSlot);
        bookingList.add(newBooking);
        bookingNotifier.notifyObservers(newBooking, "created");
        return newBooking;
    }

    private boolean checkRoomAvailableForBooking(List<Booking> bookings, String date, String timeSlot) {
        boolean result = true;
        for (Booking booking : bookings) {
            result = result && checkRoomAvailableForBooking(booking, date, timeSlot);
        }
        return result;
    }

    private boolean checkRoomAvailableForBooking(Booking booking, String date, String timeSlot) {
        if (!booking.date.equals(date)) {
            return true;
        }
        return !BookingSystemUtil.timeSlotCrossing(booking.getTimeSlot(), timeSlot);
    }

}
