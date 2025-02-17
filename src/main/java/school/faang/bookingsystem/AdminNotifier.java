package school.faang.bookingsystem;

public class AdminNotifier implements BookingObserver {
    @Override
    public void uptade(Booking booking, String status) {
        System.out.println("Администратор уведомлен: " +
                "Бронирование ID: " + booking.getBookingId() +
                " статус: " + status);
    }
}
