package school.faang.task_44723.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
public class Booking {
    private final int id;
    private final Room room;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
}
