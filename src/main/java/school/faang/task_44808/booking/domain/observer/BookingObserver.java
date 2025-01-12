package school.faang.task_44808.booking.domain.observer;

import school.faang.task_44808.booking.domain.enumeration.BookingStatus;
import school.faang.task_44808.booking.domain.model.Booking;

public interface BookingObserver {
    void update(Booking booking, BookingStatus status);
}
