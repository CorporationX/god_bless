package school.faang.job.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class DateRange implements Comparable<DateRange> {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private Granularity granularity;

    public DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        granularity = Granularity.DAILY;
    }

    public static boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateRange dateRange = (DateRange) o;
        return Objects.equals(startDate, dateRange.startDate) && Objects.equals(endDate, dateRange.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return switch (granularity) {
            case DAILY -> startDate.toString();
            case WEEKLY -> startDate.toString() + " - " + endDate.toString();
            case MONTHLY -> startDate.getMonth().toString();
        };
    }

    @Override
    public int compareTo(DateRange range) {
        return startDate.compareTo(range.getStartDate());
    }
}
