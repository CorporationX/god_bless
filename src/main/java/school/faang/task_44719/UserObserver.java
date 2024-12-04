package school.faang.task_44719;

public class UserObserver implements BookingObserver {

    @Override
    public void update(Booking booking, String status) {
        System.out.println("UserObserver " + booking + " is " + status);
    }
}