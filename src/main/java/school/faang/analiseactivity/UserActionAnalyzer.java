package school.faang.analiseactivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserActionAnalyzer {

    public List<String> topActiveUsers(List<UserAction> actions, int limit) {
        Map<Integer, List<UserAction>> userActivity = new HashMap<>();
        filterNonNull(actions).forEach(action ->
                userActivity.computeIfAbsent(action.getId(), activity -> new ArrayList<>()).add(action));
        return userActivity.entrySet().stream()
                .sorted(Comparator.comparingInt(userAction -> userAction.getValue().size()))
                .limit(limit).map(userAction -> userAction.getValue().get(0).getName()).toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        Map<String, Long> popularHashTags = new HashMap<>();
        filterNonNull(actions).stream().map(UserAction::getContent).map(this::extractHashtags).filter(Objects::nonNull)
                .forEach(hashTag -> popularHashTags.merge(hashTag, 1L, Long::sum));
        return popularHashTags.entrySet().stream()
                .sorted((popularHashTag1, popularHashTags2) ->
                        (int) (popularHashTags2.getValue() - popularHashTag1.getValue()))
                .limit(limit).map(Map.Entry::getKey).toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        Map<String, Long> topCommenters = new HashMap<>();
        filterNonNull(actions).stream().filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .forEach(userAction -> topCommenters.merge(userAction.getName(), 1L, Long::sum));
        return topCommenters.entrySet().stream().sorted((user1, user2) ->
                (int) (user2.getValue() - user1.getValue())).map(Map.Entry::getKey).limit(limit).toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<ActionType, Double> typesNumber = new HashMap<>();
        Map<String, Double> typePercentage = new HashMap<>();
        filterNonNull(actions).forEach(action -> typesNumber.merge(action.getActionType(), 1.0, Double::sum));
        typesNumber
                .forEach((key, value) -> typePercentage.put(key.toString(), value / actions.size()));
        return typePercentage;
    }

    private String extractHashtags(String content) {
        Matcher matcher = Pattern.compile("#\\w+").matcher(content);
        return matcher.find() ? matcher.group() : null;
    }

    private <T> List<T> filterNonNull(List<T> list) {
        return list == null ? Collections.emptyList() : list.stream().filter(Objects::nonNull).toList();
    }
}
