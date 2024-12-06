package school.faang.task_44721.model;

import school.faang.task_44721.BookingObserver;
import school.faang.task_44721.enums.BookingStatus;

public class Admin implements BookingObserver {
    @Override
    public void update(Booking booking, BookingStatus status) {
        System.out.printf("Запись с id: %d изменилась, статус: %s%n", booking.id(), status);
    }
}
