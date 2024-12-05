package school.faang.task_43514.model;

import school.faang.task_43514.BookingObserver;
import school.faang.task_43514.enums.BookingStatus;

public class Admin implements BookingObserver {
    @Override
    public void update(Booking booking, BookingStatus status) {
        System.out.println("Запись с id: %d изменилась, статус: %s".formatted(booking.getId(), status));
    }
}
