package school.faang.task_44721;

import school.faang.task_44721.enums.BookingStatus;
import school.faang.task_44721.model.Booking;

public interface BookingObserver {
    void update(Booking booking, BookingStatus status);
}
