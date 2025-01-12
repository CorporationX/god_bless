package school.faang.task_44808.booking.domain.validator;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.booking.domain.timeslot.BookingDate;
import school.faang.task_44808.booking.domain.timeslot.BookingTime;
import school.faang.task_44808.common.validator.Validator;
import school.faang.task_44808.room.domain.model.Room;

import java.time.LocalDate;

@Slf4j
public class BookingValidator {
    private final Validator<LocalDate> dateValidator;

    public BookingValidator(Validator<LocalDate> dateValidator) {
        this.dateValidator = dateValidator;
    }

    public void validateBooking(Room room, BookingDate date, BookingTime timeSlot) {
        dateValidator.validate(date.getDate());
    }
}
