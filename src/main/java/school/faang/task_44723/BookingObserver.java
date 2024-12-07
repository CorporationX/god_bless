package school.faang.task_44723;

import school.faang.task_44723.model.Booking;
import school.faang.task_44723.model.BookingStatus;

public interface BookingObserver {
    void update(Booking booking, BookingStatus status);
}
