package school.faang.task_43514;

import school.faang.task_43514.enums.BookingStatus;
import school.faang.task_43514.model.Booking;

public interface BookingObserver {
    void update(Booking booking, BookingStatus status);
}
