package school.faang.bjs2_68833;

import java.util.concurrent.atomic.AtomicLong;


public class BookingIdCounter {
    private static final AtomicLong BOOKING_ID = new AtomicLong();

    public static long getNextBookingId() {
        return BOOKING_ID.get();
    }
}
