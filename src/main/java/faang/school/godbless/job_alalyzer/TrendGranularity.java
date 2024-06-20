package faang.school.godbless.job_alalyzer;

import lombok.Getter;

import java.time.LocalDate;
import java.util.function.Function;

@Getter
public enum TrendGranularity {
    DAILY((localDate) -> localDate.plusDays(1)),
    WEEKLY((localDate) -> localDate.plusWeeks(1)),
    MONTHLY((localDate) -> localDate.plusMonths(1)),
    YEARLY((localDate) -> localDate.plusYears(1));

    private final Function<LocalDate, LocalDate> function;

    TrendGranularity(Function<LocalDate, LocalDate> function) {
        this.function = function;
    }
}
