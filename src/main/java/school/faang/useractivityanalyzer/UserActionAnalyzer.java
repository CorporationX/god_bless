package school.faang.useractivityanalyzer;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern HASHTAG = Pattern.compile("#\\w+");

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int top) {
        if (top <= 0) {
            throw new IllegalArgumentException("Top must be positive, but was %d" + top);
        }
        Map<String, Long> repetitionsByUserName = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::userName,
                        Collectors.counting()));

        return repetitionsByUserName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int top) {
        if (top <= 0) {
            throw new IllegalArgumentException("Top must be positive, but was %d" + top);
        }
        List<String> hashtags = actions.stream()
                .flatMap(action -> {
                    Matcher matcher = HASHTAG.matcher(action.content());
                    List<String> tags = new ArrayList<>();
                    while (matcher.find()) {
                        tags.add(matcher.group());
                    }
                    return tags.stream();
                })
                .toList();

        Map<String, Long> repetitionsByHashTag = hashtags.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        return repetitionsByHashTag.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int top) {
        if (top <= 0) {
            throw new IllegalArgumentException("Top must be positive, but was %d" + top);
        }
        Map<String, Long> commentsValueByUser = actions.stream()
                .filter(action -> action.actionType() == ActionType.COMMENT
                        && !action.actionDate().isBefore(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(
                        UserAction::userName,
                        Collectors.counting()));

        return commentsValueByUser.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        if (actions.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, Double> actionTypeCounts = actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.actionType().toString(),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> {
                                    double percentage = count * 100.0 / actions.size();
                                    return BigDecimal.valueOf(percentage)
                                            .setScale(2, RoundingMode.HALF_UP)
                                            .doubleValue();
                                })));

        return actionTypeCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new));
    }
}
