package school.faang.bookingsystem;

public class GuestNotifier implements BookingObserver {
    @Override
    public void uptade(Booking booking, String status) {
        System.out.println("Гость уведомлен: " +
                "Бронирование ID: " + booking.getBookingId() +
                " статус: " + status);
    }
}
