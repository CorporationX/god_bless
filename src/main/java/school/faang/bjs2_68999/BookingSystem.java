package school.faang.bjs2_68999;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class BookingSystem {
    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();

    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public void removeRoom(int roomNumber) {
        rooms.remove(roomNumber);
    }

    public void bookRoom(int roomNumber, String date, int timeSlot) {
        Booking booking = new Booking(rooms.get(roomNumber), date, timeSlot);
        
        if (!rooms.containsKey(roomNumber)) {
            log.warn("Комната {} отсутствует. Пожалуйста, зарегистрируйте комнату.", roomNumber);
            return;
        }

        if (isBooked(roomNumber, date, timeSlot)) {
            log.warn("Комната {} уже забронирована на период с {} даты.", roomNumber, date);
            return;
        }
        
        bookings.put(booking.getBookingId(), booking);
        BookingNotifier.notifyObservers(booking, "добавлена");
    }

    public void cancelBooking(int bookingId) {
        Booking removedBooking = bookings.remove(bookingId);
        if (removedBooking == null) {
            log.warn("Букинга {} в системе уже нет.", bookingId);
            return;
        }
        BookingNotifier.notifyObservers(removedBooking, "удалена");
    }

    public List<Room> findAvailableRooms(String date, int timeslot, Set<String> requiredAmenities) {
        List<Room> availableRooms = new ArrayList<>();
        for (Entry<Integer, Room> entry : rooms.entrySet()) {
            if (entry.getValue().getAmenities().containsAll(requiredAmenities)) {
                if (!isBooked(entry.getValue().getRoomNumber(), date, timeslot)) {
                    availableRooms.add(entry.getValue());
                }
            }
        }
        return availableRooms;
    }

    public List<Booking> findBookingsForDate(String date) {
        int numberOfBookedDays = 1;
        List<Booking> activeBookingsOnDate = new ArrayList<>();
        for (Entry<Integer, Booking> entry : bookings.entrySet()) {
            LocalDate startDate = LocalDate.parse(date);
            LocalDate endDate = startDate.plusDays(numberOfBookedDays);
            LocalDate bookingStartDate = LocalDate.parse(entry.getValue().getDate());
            LocalDate bookingEndDate = bookingStartDate.plusDays(entry.getValue().getTimeSlot());
            Boolean overlaps = overlaps(startDate, endDate, bookingStartDate, bookingEndDate);
            Boolean contains = contains(startDate, endDate, bookingStartDate, bookingEndDate);
            if (overlaps || contains) {
                activeBookingsOnDate.add(entry.getValue());
            }
        }
        return activeBookingsOnDate;
    }

    public boolean isBooked(int roomNumber, String date, int timeSlot) {
        Boolean isBooked = false;
        for (Entry<Integer, Booking> entry : bookings.entrySet()) {
            if (entry.getValue().getRoom().getRoomNumber() != roomNumber) {
                continue;
            } else {
                LocalDate startDate = LocalDate.parse(date);
                LocalDate endDate = startDate.plusDays(timeSlot);
                LocalDate bookingStartDate = LocalDate.parse(entry.getValue().getDate());
                LocalDate bookingEndDate = bookingStartDate.plusDays(entry.getValue().getTimeSlot());
                Boolean overlaps = overlaps(startDate, endDate, bookingStartDate, bookingEndDate);
                Boolean contains = contains(startDate, endDate, bookingStartDate, bookingEndDate);
                if (overlaps || contains) {
                    isBooked = true;
                }
            }
        }
        return isBooked;
    }

    public boolean overlaps(
        LocalDate startDate, 
        LocalDate endDate, 
        LocalDate bookingStartDate, 
        LocalDate bookingEndDate
    ) {
        return !startDate.isAfter(bookingEndDate) && !endDate.isBefore(bookingStartDate);
    }

    public boolean contains(
        LocalDate startDate, 
        LocalDate endDate, 
        LocalDate bookingStartDate, 
        LocalDate bookingEndDate
    ) {
        return !startDate.isAfter(bookingStartDate) && !endDate.isBefore(bookingEndDate);
    }

}
