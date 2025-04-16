package school.faang.stream1.bookingsystem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BookingSystemUtil {
    public static boolean timeSlotCrossing(String ts0, String ts1) {
        return timeSlotFormatCheck(ts0, ts1)
                && IntStream.range(0, 96).anyMatch(i -> ts0.charAt(i) == '1' && ts1.charAt(i) == '1');
    }

    /**
     * timestamp is a String 96 characters long,
     * each character could be 0 or 1 and represents 15 minutes long interval of a day
     * 0 represents free slot
     * 1 represents booked slot
     */
    public static boolean timeSlotFormatCheck(String... timeStamps) throws RuntimeException {
        return Arrays.stream(timeStamps).allMatch(
                ts -> (ts != null && ts.length() == 96 && ts.matches("[01]+"))
        );
    }

    public static Optional<Room> getRoomByNumber(List<Room> roomList, int roomNumber) {
        return roomList.stream()
                .filter(r -> roomNumber == r.getRoomNumber())
                .findFirst();
    }

    public static Optional<Booking> getBookingById(List<Booking> bookingList, int bookingNumber) {
        return bookingList.stream()
                .filter(r -> bookingNumber == r.getBookingId())
                .findFirst();
    }

}
