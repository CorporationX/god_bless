package school.faang.task_44719;

public class HotelObserver implements BookingObserver {

    @Override
    public void update(Booking booking, String status) {
        System.out.println("HotelObserver " + booking + " is " + status);
    }
}
