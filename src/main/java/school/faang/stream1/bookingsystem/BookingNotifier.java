package school.faang.stream1.bookingsystem;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    //Хранить список наблюдателей (BookingObserver).
    private final List<BookingObserver> observers;

    // Иметь методы addObserver(BookingObserver observer) и removeObserver(BookingObserver observer)
    // для добавления и удаления наблюдателей.
    public boolean addObserver(BookingObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(BookingObserver observer) {
        return observers.remove(observer);
    }

    //Содержать метод notifyObservers(Booking booking, String status),
    // который будет вызывать метод update для всех зарегистрированных наблюдателей,
    // уведомляя их об изменении статуса бронирования.
    public void notifyObservers(Booking booking, String status) {
        observers.forEach(bookingObserver -> bookingObserver.update(booking, status));
    }

    public BookingNotifier() {
        this.observers = new ArrayList<>();
    }
}
