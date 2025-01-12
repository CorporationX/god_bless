package school.faang.task_44808.booking.domain.validator;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.common.validator.Validator;

import java.time.LocalDate;

@Slf4j
public class BookingDateValidator implements Validator<LocalDate> {
    public static final int MAX_DAYS_IN_ADVANCE = 90;

    @Override
    public void validate(LocalDate date) {
        final LocalDate today = LocalDate.now();

        if (date.isBefore(today)) {
            log.warn("Booking date `{}` is in the past", date);
            throw new IllegalArgumentException("Booking date cannot be in the past: " + date);
        }

        if (date.isAfter(today.plusDays(MAX_DAYS_IN_ADVANCE))) {
            log.warn("Booking date `{}` is more than {} days in the future", date, MAX_DAYS_IN_ADVANCE);
            throw new IllegalArgumentException(
                    "Booking date cannot be more than " + MAX_DAYS_IN_ADVANCE + " days in the future: " + date
            );
        }
    }
}