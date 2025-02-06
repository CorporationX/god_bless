package school.faang.observer;

import school.faang.model.Booking;

public interface BookingObserver {
    /**
     * Called when a booking is created or cancelled.
     *
     * @param booking The booking instance.
     * @param status  The status of the booking (e.g., Booked, Cancelled).
     */
    void update(Booking booking, String status);
}
