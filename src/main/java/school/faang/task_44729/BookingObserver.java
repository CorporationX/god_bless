package school.faang.task_44729;

@FunctionalInterface
public interface BookingObserver {
    void update(Booking booking, String status);

}
