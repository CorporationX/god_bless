package school.faang.stream1.bookingsystem;

import java.util.List;
import java.util.Set;

public class BookingSystem {
    private List<Booking> bookingList;
    private List<Room> roomList;

    // — добавляет комнату в систему.
    public Room addRoom(Room room) {
        return null;
    }

    // — удаляет комнату из системы.
    public Room removeRoom(int roomNumber) {
        return null;
    }

    // — бронирует комнату на указанную дату и временной интервал, если она доступна.
    // При успешном бронировании уведомляет всех наблюдателей.
    public Booking bookRoom(int roomNumber, String date, String timeSlot) {
        return null;
    }

    // — отменяет бронирование и уведомляет всех наблюдателей.
    public Booking cancelBooking(int bookingId) {
        return null;
    }

    // — возвращает список доступных комнат, которые подходят по дате, времени и набору удобств.
    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        return null;
    }

    //additional
    public List<Room> findBookingsForDate(String date) {
        return null;
    }
}
