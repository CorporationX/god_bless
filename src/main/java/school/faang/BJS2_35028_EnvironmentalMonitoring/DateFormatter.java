package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private static final String YEAR_MONTH_FORMAT = "yyyy.MM";

    public static String getYearAndMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YEAR_MONTH_FORMAT);
        return date.format(formatter);
    }
}
