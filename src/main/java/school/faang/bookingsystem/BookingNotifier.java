package school.faang.bookingsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingNotifier {
    private final Set<BookingObserver> observers = new HashSet<>();

    public BookingObserver addObserver(BookingObserver observer) {
        if (observer == null) {
            throw new NullPointerException("Наблюдатель не может быть null.");
        }

        if (observers.contains(observer)) {
            throw new IllegalArgumentException("Этот Наблюдатель уже есть в списке.");
        }

        observers.add(observer);
        System.out.println("Наблюдатель: " + observer + " успешно добавлен!");
        return observer;
    }

    public BookingObserver removeObserver(BookingObserver observer) {
        if (observer == null) {
            throw new NullPointerException("Наблюдатель не может быть null.");
        }

        if (!observers.contains(observer)) {
            throw new IllegalArgumentException("Этот Наблюдатель отсутствует в этом списке: " + observer);
        }

        observers.remove(observer);
        return observer;
    }

    public void notifyObservers(Booking booking, String status) {
        if (status == null) {
            throw new NullPointerException("Статус не может быть null.");
        }

        if (status.isEmpty()) {
            throw new IllegalArgumentException("Статус не может быть пустым.");
        }

        if (booking == null) {
            throw new NullPointerException("Бронирование не может быть null.");
        }

        for (BookingObserver observer : observers) {
            observer.uptade(booking, status);
        }
    }
}
