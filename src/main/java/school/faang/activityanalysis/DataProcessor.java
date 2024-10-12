package school.faang.activityanalysis;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataProcessor {
    public static List<String> topTenUsers(List<UserAction> activity) {
        return activity.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getFivePopularTags(List<UserAction> activityUsers) {
        return activityUsers.stream()
                .map(searchHashTag)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .limit(5)
                .toList();
    }

    public static List<String> topThreeUsersIsActive(List<UserAction> activityUsers) {
        return activityUsers.stream()
                .filter(isCurrentDate)
                .map(UserAction::name)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> getActionRatio(List<UserAction> activityUsers) {
        int sizeActives = activityUsers.size();
        Map<String, Long> allActives = activityUsers.stream()
                .map(UserAction::actionType)
                .collect(Collectors.groupingBy(action-> action, Collectors.counting()));
        return activityPercentage(allActives, sizeActives);
    }

    //Функциональные интерфейсы и вспомогательные методы

    private static Function<UserAction, String> searchHashTag = user -> {
        String content = user.content();
        int index = content.indexOf("#");
        String phrase = content.substring(index + 1);
        String[] words = phrase.split("\\PL");
        return words[0];
    };

    private static final Predicate<UserAction> isCurrentDate = user -> {
        LocalDate userDate = user.date();
        LocalDate today = LocalDate.now();
        LocalDate firstDayLastMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDayLastMonth =
                today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth());
        return !userDate.isBefore(firstDayLastMonth) && !userDate.isAfter(lastDayLastMonth);
    };

    private static Map<String, Double> activityPercentage(Map<String, Long> allActives, int sizeActives) {
        return allActives.entrySet().stream()
                .map( active -> convertToPercentage(sizeActives, active))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map.Entry<String, Double> convertToPercentage(Integer size, Map.Entry<String, Long> active) {
        double percentage =  ( (double) active.getValue() / size) * 100;
        return new AbstractMap.SimpleEntry<>(active.getKey(), percentage);
    }
}

