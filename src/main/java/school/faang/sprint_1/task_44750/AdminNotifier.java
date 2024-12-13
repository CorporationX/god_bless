package school.faang.sprint_1.task_44750;

public class AdminNotifier implements BookingObserver {
    @Override
    public void update(Booking booking, String status) {
        System.out.println("Уведомление: \n"  + booking + status);
    }
}
