package faang.school.godbless.VacancyAnalyzer;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> mostRequiredSkills(List<Job> jobList) {
        return jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<String> mostPopularTitles(List<Job> jobList) {
        return jobList.stream()
                .map(Job::getTitle)
                .flatMap(title -> Arrays.stream(title.split(" ")))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> rangeOfSalaries(List<Job> jobList) {
        Map<String, Integer> result = new java.util.HashMap<>(Map.of("Less then 1000", 0, "1001-2000", 0, "More then 2001", 0));
        jobList.stream()
                .map(Job::getSalary)
                .forEach(salary -> {
                    if (salary <= 1000) {
                        result.put("Less then 1000", result.get("Less then 1000") + 1);
                    } else if (salary <= 2000) {
                        result.put("1001-2000", result.get("1001-2000") + 1);
                    } else {
                        result.put("More then 2001", result.get("More then 2001") + 1);
                    }
                });
        return result;
    }

    public static List<String> mostPopularLocations(List<Job> jobList) {
        return jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<Statistics> analyzeTrends(Date startDate, Date endDate, TrendGranularity granularity, List<Job> jobList) {
        Map<List<Date>, List<Job>> groupedDates = getGroupedDates(startDate, endDate, granularity, jobList);
        return groupedDates.entrySet()
                .stream()
                .map(entry -> {
                    Statistics statistics = new Statistics();
                    statistics.setRange(List.of(entry.getKey().get(0), entry.getKey().get(entry.getKey().size() - 1)));
                    statistics.setVacancyQuantity(entry.getValue().size());
                    statistics.setMostRequiredSkills(mostRequiredSkills(entry.getValue()));
                    statistics.setSalaryRanges(rangeOfSalaries(entry.getValue()));
                    statistics.setMostPopularLocations(mostPopularLocations(entry.getValue()));
                    return statistics;
                })
                .collect(Collectors.toList());
    }

    private static Map<List<Date>, List<Job>> getGroupedDates(Date startDate, Date endDate, TrendGranularity granularity, List<Job> jobList) {
        int daysInGranularity = granularity.getDays();
        List<Date> datesInRange = groupDates(startDate, endDate);
        Map<List<Date>, List<Job>> groupedDates = makeMapWithGroupDates(datesInRange, daysInGranularity);
        jobList.forEach(job -> {
            groupedDates.forEach((dates, jobs) -> {
                if (dates.stream().map(Date::getDate).toList().contains(job.getCreatedAt().getDate())) {
                    jobs.add(job);
                }
            });
        });
        return groupedDates;
    }

    private static Calendar getCalendarWithoutTime(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    private static List<Date> groupDates(Date startInclusive, Date endExclusive) {
        List<Date> group = new ArrayList<>();
        Calendar start = getCalendarWithoutTime(startInclusive);
        Calendar end = getCalendarWithoutTime(endExclusive);
        while (start.before(end)) {
            Date result = start.getTime();
            group.add(result);
            start.add(Calendar.DATE, 1);
        }
        return group;
    }

    private static Map<List<Date>, List<Job>> makeMapWithGroupDates(List<Date> datesInRange, int daysInGranularity) {
        Map<List<Date>, List<Job>> groupedDates = new HashMap<>();
        int j = 0;
        for (int i = 0; datesInRange.size() - i >= daysInGranularity; i += daysInGranularity) {
            List<Date> list = datesInRange.subList(i, i + daysInGranularity);
            groupedDates.put(list, new ArrayList<>());
            j += daysInGranularity;
        }
        List<Date> temp = new ArrayList<>();
        while (j < datesInRange.size()) {
            temp.add(datesInRange.get(j++));
        }
        groupedDates.put(temp, new ArrayList<>());
        return groupedDates;
    }
}
