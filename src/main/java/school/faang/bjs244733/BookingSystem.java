package school.faang.bjs244733;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BookingSystem {

    // Хранит список комнат и бронирований
    private List<Room> rooms;
    private List<Booking> listBooking;

    @NonNull
    private BookingNotifier bookingNotifier;


    // — добавляет комнату в систему.
    public void addRoom(Room room) {
        rooms.add(room);
    }


    //— удаляет комнату из системы.
    public void removeRoom(int roomId) {
        Room room = getRoomById(roomId);
        rooms.remove(room);
    }

    private Room getRoomById(int roomId) {
        return null;
    }

    //— бронирует комнату на указанную дату и временной интервал, если она доступна.
    public void bookRoom(int roomId, String date, String timeSlot) {

        // уведомление При успешном бронировании уведомляет всех наблюдателей
        Booking booking = createBooking(roomId, date, timeSlot);
        listBooking.add(booking);
        bookingNotifier.notifyObservers(booking, Status.RESERVED);
    }

    private Booking createBooking(int roomId, String date, String timeSlot) {

        Map<Integer, Booking> result = listBooking
                .stream()
                .collect(Collectors.toMap(v -> v.getRoom().getRoomId(), Function.identity()));

        if (result.containsKey(roomId)) {
            Booking booking = result.get(roomId);
            String dateRest = getDateRest(booking);
            if (isDatelonger(dateRest, date)) {

            }


        }

        return null;
    }

    private boolean isDatelonger (String dateRest, String date){
        if (dateRest.equals("gfddggffg")) {
            return true;
        }
        return true;
    }




    private String getDateRest(Booking booking) {
        return "";
    }

    // отменяет бронирование и уведомляет всех наблюдателей.
    public void cancelBooking(int bookingId) {
        Booking booking = getBookingById(bookingId);
        if (booking != null) {
            listBooking.remove(booking);
            bookingNotifier.notifyObservers(booking, Status.AVAILABLE);
        }
    }

    private Booking getBookingById(int bookingId) {
        return listBooking.stream()
                .filter(v -> v.getBookingId() == bookingId)
                .findFirst().orElse(null);
    }


    // — возвращает список доступных комнат, которые подходят по дате, времени и набору удобств.
    public void findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {

    }

}
