package school.faang.task_44726.observer;

import school.faang.task_44726.Booking;

public interface BookingObserver {
    void update(Booking booking, String status);
}
