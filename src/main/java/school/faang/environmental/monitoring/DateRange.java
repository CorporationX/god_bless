package school.faang.environmental.monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class DateRange implements Comparable<DateRange> {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }

    public boolean isDateInRange(LocalDate date) {
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
        return startDate.toString() + " - " + endDate.toString();
    }

    @Override
    public int compareTo(DateRange range) {
        return startDate.compareTo(range.getStartDate());
    }
}
