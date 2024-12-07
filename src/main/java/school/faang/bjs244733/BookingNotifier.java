package school.faang.bjs244733;

import lombok.Getter;

import java.util.List;

public class BookingNotifier {

    @Getter
    private List<BookingObserver> observers;

    public void addObserver(BookingObserver observer){
        observers.add(observer);
    }
    public void removeObserver(BookingObserver observer){
        observers.remove(observer);
    }

    //метод update для всех зарегистрированных наблюдателей, уведомляя их об изменении статуса бронирования.
    public void notifyObservers(Booking booking, Status status){
        for(BookingObserver bookingObserver : observers){
            bookingObserver.update(booking, status);
        }
    }


}
