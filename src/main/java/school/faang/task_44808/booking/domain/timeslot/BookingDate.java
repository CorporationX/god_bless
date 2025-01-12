package school.faang.task_44808.booking.domain.timeslot;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class BookingDate {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final LocalDate date;

    public BookingDate(String date) {
        this.date = LocalDate.parse(date, FORMATTER);
    }

    @Override
    public String toString() {
        return date.format(FORMATTER);
    }
}