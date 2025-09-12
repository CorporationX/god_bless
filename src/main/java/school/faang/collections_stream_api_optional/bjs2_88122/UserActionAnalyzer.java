package school.faang.collections_stream_api_optional.bjs2_88122;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class UserActionAnalyzer {
    private static final BiFunction<Pattern, String, Optional<String>> extractSubstring = (Pattern pattern,
                                                                                           String string) -> {
        if (string == null) {
            return Optional.empty();
        }

        Matcher m = pattern.matcher(string);
        return m.find()
                ? Optional.of(m.group(1))
                : Optional.empty();
    };

    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int limit) {
        return userActions.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(UserAction::getUserId)).entrySet()
                .stream()
                .sorted(Map.Entry
                        .<Integer, List<UserAction>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .limit(limit)
                .map(itemListUser -> itemListUser
                        .getValue()
                        .get(0)
                        .getUserName())
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int limit) {
        Pattern regHashTag = Pattern.compile("#([\\p{L}\\p{M}]+)");

        return userActions.stream()
                .filter(Objects::nonNull)
                .filter(user -> List.of(ActionType.COMMENT,
                        ActionType.POST).contains(user.getActionType()))
                .filter(user -> extractSubstring.apply(regHashTag,
                        user.getContent()).isPresent())
                .collect(groupingBy(user -> extractSubstring.apply(regHashTag, user.getContent()).get()))
                .entrySet().stream()
                .sorted(Map.Entry
                        .<String, List<UserAction>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int limit) {
        return userActions.stream()
                .filter(Objects::nonNull)
                .filter(user -> user.getActionType() == ActionType.COMMENT)
                .collect(groupingBy(UserAction::getUserId))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<UserAction>>
                        comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .limit(limit)
                .map(itemListUser -> itemListUser
                        .getValue()
                        .get(0)
                        .getUserName())
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> userActions) {
        int countActions = userActions.size();
        return userActions.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(UserAction::getActionType))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        item -> item.getValue().size() * 100 / (double) countActions));
    }
}