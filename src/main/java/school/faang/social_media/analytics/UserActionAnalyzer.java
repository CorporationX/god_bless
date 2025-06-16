package school.faang.social_media.analytics;

import school.faang.social_media.analytics.entity.UserAction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .map(entry -> entry.getValue().get(0).getName())
                .limit(n)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
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
}
