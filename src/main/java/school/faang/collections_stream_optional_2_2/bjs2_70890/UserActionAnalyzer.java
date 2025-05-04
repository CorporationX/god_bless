package school.faang.collections_stream_optional_2_2.bjs2_70890;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UserActionAnalyzer {
    public List<String> getTopActiveUsers(List<UserAction> userActions, int qty) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(qty)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopDiscussedTopics(List<UserAction> userActions, int qty) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST)
                        || userAction.getActionType().equals(ActionType.COMMENT))
                .flatMap(userAction -> getHashtagsStream(userAction.getContent()))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(qty)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopCommentatorsForMonth(List<UserAction> userActions, int qty) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT)
                        && userAction.getActionDate().isAfter(getDateOneMonthAgo()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(qty)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> calculateActionTypePercentages(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> BigDecimal.valueOf(entry.getValue() * 100.0 / userActions.size())
                                .setScale(2, RoundingMode.HALF_UP)
                                .doubleValue()
                ));
    }

    private static Stream<String> getHashtagsStream(String content) {
        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(content);
        return matcher.results()
                .map(matchResult -> matchResult.group(1).toLowerCase());
    }

    private static LocalDate getDateOneMonthAgo() {
        return LocalDate.now().minusMonths(1);
    }
}
