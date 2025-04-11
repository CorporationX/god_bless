package school.faang.bjs2_68833;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingIdCounter {
    private static long bookingId = 0;

    public static long getNextBookingId() {
        return ++bookingId;
    }
}
