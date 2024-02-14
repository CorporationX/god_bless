package AnalyzatorVakansiy;

import java.time.LocalDate;

public enum TrendGranularity {
    DAILY,
    WEEKLY,
    MONTHLY;

    public LocalDate adjustStartDate(LocalDate startDate) {
        switch (this) {
            case WEEKLY:
                return startDate.minusDays(startDate.getDayOfWeek().getValue() - 1);
            case MONTHLY:
                return startDate.withDayOfMonth(1);
            default:
                return startDate;
        }
    }
}
