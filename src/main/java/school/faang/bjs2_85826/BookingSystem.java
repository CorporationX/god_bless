package school.faang.bjs2_85826;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.List;


@Setter
@Getter
public class BookingSystem {
    private List<Room> listInfoRoom = new ArrayList<>();
    private BookingNotifier notifier = new BookingNotifier();
    private List<Booking> bookingList = new ArrayList<>();

    public void add(Room room) {
        if (listInfoRoom.contains(room)) {
            listInfoRoom.add(room);
            System.out.printf("The room with number %x was added \n", room.getRoomNumber());
        } else {
            System.out.printf("The room with number %x already exists \n", room.getRoomNumber());
        }
    }

    public void remove(int roomNumber) {
        Room room = listInfoRoom.stream()
                .filter(i -> i.getRoomNumber() == roomNumber)
                .findFirst()
                .orElseThrow();
        listInfoRoom.remove(room);
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        Optional<Room> room = listInfoRoom.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst();
        if (room.isEmpty()) {
            System.out.printf("Sorry!!! Room with number %x is busy((!!! Sorry!!!", roomNumber);
        } else {
            Booking booking = new Booking(AtomicCounter.incrementId(), room.get(), date, timeSlot);
            notifier.notifyObservers(booking, "booked");
            System.out.println("Room with number %x was booked");
            listInfoRoom.add(room.get());
            bookingList.add(booking);
        }
    }

    public List<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        List<Room> resultList = new ArrayList<>(listInfoRoom);

        List<Room> bookingRoomList = bookingList.stream()
                .filter(booking -> !Objects.equals(date, booking.getDate())
                        && !Objects.equals(timeSlot, booking.getTimeSlot()))
                .map(Booking::getRoom)
                .toList();

        resultList.removeAll(bookingRoomList);

        return resultList.stream().filter(room -> room.getAmenities().containsAll(requiredAmenities)).toList();
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookingList.stream()
                .filter(book -> Objects.equals(bookingId, book.getBookingId()))
                .findFirst()
                .orElseThrow();
        bookingList.remove(booking);
        notifier.notifyObservers(booking, "Cancel");


    }
}
