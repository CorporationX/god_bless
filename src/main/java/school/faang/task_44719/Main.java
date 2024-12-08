package school.faang.task_44719;

import java.util.List;
import java.util.Set;


public class Main {
    private static int nextRoomId = 0;

    public static void main(String[] args) {
        BookingNotifier notifier = new BookingNotifier();
        BookingSystem system = new BookingSystem(notifier);
        notifier.addObserver(new HotelObserver());
        notifier.addObserver(new UserObserver());
        createAndAddRoom(system, "конференц-зал", Set.of("проектор", "доска"));
        createAndAddRoom(system, "переговорная", Set.of("видеоконференция", "микрофоны"));
        bookRoom(system, "21.12.2024", "10.00-12.00", Set.of("видеоконференция", "микрофоны"));
        bookRoom(system, "10.12.2024", "20.00-22.00", Set.of("проектор", "доска"));
        List<Booking> bookings = system.findBookingsForDate("21.12.2024");
        if ((bookings != null) && (!bookings.isEmpty())) {
            System.out.println("Найдены бронирования на 21.12.2024: ");
            bookings.forEach(System.out::println);
            if (system.cancelBooking(bookings.get(0).getBookingId())) {
                System.out.println("Бронирование отменено.");
            } else {
                System.out.println("Бронирование не найдено");
            }
        }
        for (int count = 0; count < nextRoomId; count++) {
            if (system.removeRoom(count)) {
                System.out.println("Комната с ID " + count + " успешно удалена.");
            } else {
                System.out.println("Комната с ID " + count + " не найдена.");
            }
        }
    }

    private static void bookRoom(BookingSystem system, String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRooms = system.findAvailableRooms(date, timeSlot, requiredAmenities);
        if ((availableRooms != null) && (!availableRooms.isEmpty())) {
            System.out.println("Найдены подходящие комнаты: ");
            availableRooms.forEach(System.out::println);
            Booking booking = system.bookRoom(availableRooms.get(0).getRoomId(), date, timeSlot);
            if (booking != null) {
                System.out.println("Комната с Id " + availableRooms.get(0).getRoomId() + " забронирована");
            } else {
                System.out.println("Комната с Id " + availableRooms.get(0).getRoomId() + " не забронирована");
            }
        } else {
            System.out.println("Не найдены подходящие комнаты. Ничего не забронировано.");
        }
    }

    private static void createAndAddRoom(BookingSystem system, String type, Set<String> amenities) {
        if (system.addRoom(new Room(nextRoomId, type, amenities))) {
            System.out.println("Комната с ID " + nextRoomId + " добавлена.");
        } else {
            System.out.println("Комната с ID " + nextRoomId + " не добавлена.");
        }
        nextRoomId++;
    }
}
