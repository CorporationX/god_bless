package school.faang.stream1.bookingsystem;

import java.util.List;

public class BookingNotifier {
    //Хранить список наблюдателей (BookingObserver).
    List<BookingObserver> observers;

    //Иметь методы addObserver(BookingObserver observer) и removeObserver(BookingObserver observer)
    // для добавления и удаления наблюдателей.
    public boolean addObserver(BookingObserver observer) {
        return false;
    }

    public boolean removeObserver(BookingObserver observer) {
        return false;
    }

    //Содержать метод notifyObservers(Booking booking, String status),
    // который будет вызывать метод update для всех зарегистрированных наблюдателей,
    // уведомляя их об изменении статуса бронирования.
    public void notifyObservers(Booking booking, String status) {

    }
}
