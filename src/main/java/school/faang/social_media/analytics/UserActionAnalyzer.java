package school.faang.social_media.analytics;

import lombok.NonNull;
import school.faang.social_media.analytics.entity.UserAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int n) {
        if (actions.isEmpty()) {
            return new ArrayList<>();
        }

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .map(entry -> entry.getValue().get(0).getName())
                .limit(n)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int n) {
        if (actions.isEmpty()) {
            return new ArrayList<>();
        }

        Function<UserAction, Stream<String>> getHashtags = (action) -> {
            Stream.Builder<String> builder = Stream.builder();
            Pattern pattern = Pattern.compile("#\\w+");
            Matcher matcher = pattern.matcher(action.getContent());
            return matcher.results().map(MatchResult::group);
        };

        return actions.stream()
                .flatMap(getHashtags)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .limit(n)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int n) {
        if (actions.isEmpty()) {
            return new ArrayList<>();
        }

        LocalDate lastActivityDate = actions.stream()
                .sorted((a1, a2) -> a2.getActionDate().compareTo(a1.getActionDate()))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("not found any activity");
                })
                .getActionDate();

        Predicate<UserAction> filter = action -> {
            return action.getActionDate().getYear() == lastActivityDate.getYear()
                    && action.getActionDate().getMonth().equals(lastActivityDate.getMonth());
        };
        return actions.stream()
                .filter(filter)
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .map(entry -> entry.getValue().get(0).getName())
                .limit(n)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        if (actions.isEmpty()) {
            return new HashMap<>();
        }

        long actionCount = actions.size();
        return actions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                        entry -> (double) entry.getValue() / (double) actionCount * 100.0));
    }

}
