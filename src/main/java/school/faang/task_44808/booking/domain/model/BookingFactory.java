package school.faang.task_44808.booking.domain.model;

import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.booking.domain.validator.BookingValidator;
import school.faang.task_44808.room.domain.model.Room;

import java.util.concurrent.atomic.AtomicInteger;

public class BookingFactory {
    private final BookingValidator bookingValidator;
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public BookingFactory(BookingValidator bookingValidator, int initialCounter) {
        this.bookingValidator = bookingValidator;
        this.idCounter.set(initialCounter);
    }

    public Booking createBooking(Room room, BookingDate date, BookingTime timeSlot) {
        bookingValidator.validateBooking(room, date, timeSlot);
        return new Booking(getNextId(), room, date, timeSlot);
    }

    public synchronized int getNextId() {
        return idCounter.getAndIncrement();
    }
}
