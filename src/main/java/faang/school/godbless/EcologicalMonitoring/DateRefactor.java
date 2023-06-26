package faang.school.godbless.EcologicalMonitoring;

import java.util.*;

public class DateRefactor {
    public static Calendar getCalendarWithoutTime(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    public static List<Date> getDatesRange(Date startInclusive, Date endExclusive, int interval) {
        List<Date> group = new ArrayList<>();
        Calendar start = getCalendarWithoutTime(startInclusive);
        Calendar end = getCalendarWithoutTime(endExclusive);
        while (start.before(end)) {
            Date result = start.getTime();
            group.add(result);
            start.add(Calendar.DATE, interval);
        }
        return group;
    }
}
