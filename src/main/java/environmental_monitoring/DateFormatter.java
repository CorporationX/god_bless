package environmental_monitoring;

import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static final DateTimeFormatter FULL_DATE_SEPARATED_BY_A_DOT = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    public static final DateTimeFormatter DATE_WITH_YEAR_AND_MONTH = DateTimeFormatter.ofPattern("yyyy.MM");
}
