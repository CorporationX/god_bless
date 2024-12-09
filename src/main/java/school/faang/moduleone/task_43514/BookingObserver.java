package school.faang.moduleone.task_43514;

@FunctionalInterface
public interface BookingObserver {

    void update(Booking booking, String status);
}
