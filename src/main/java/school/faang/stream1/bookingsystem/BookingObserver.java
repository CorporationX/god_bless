package school.faang.stream1.bookingsystem;

public interface BookingObserver {
    //Этот метод будет вызываться при изменении состояния бронирования
    //(например, при создании или отмене бронирования).
    void update(Booking booking, String status);
}
