package school.faang.booking;

import school.faang.booking.domain.Booking;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public interface BookingObserver {
    void update(Booking booking, String status);
}
