package school.faang.bjs2_89400;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> getTopActiveUsers(List<UserAction> actions, int top) {
        return new ArrayList<>(actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue((firstList, secondList) ->
                        secondList.size() - firstList.size()))
                .limit(top)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    if (!entry.getValue().isEmpty()) {
                        return entry.getValue().get(0).getUserName();
                    } else {
                        return  "";
                    }
                }))
                .values());
    }

    public Set<String> getTopPopularHashtags(List<UserAction> actions, int top) {
        return new HashSet<>(actions.stream()
                .collect(Collectors.groupingBy(action -> {
                    Matcher matcher = Pattern.compile("#[a-zA-Z]+").matcher(action.getContent());
                    try {
                        if (matcher.find()) {
                            return matcher.group();
                        } else {
                            throw new IllegalStateException();
                        }
                    } catch (IllegalStateException e) {
                        return "";
                    }
                }))
                .entrySet().stream()
                .filter(entry -> !entry.getKey().isEmpty())
                .sorted(Map.Entry.comparingByValue((firstList, secondList) ->
                        secondList.size() - firstList.size()))
                .limit(top)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet());
    }

    public List<String> getTopCommentersLastMonth(List<UserAction> actions, int top) {
        return new ArrayList<>(actions.stream()
                .filter(action -> action.getActionDate()
                        .isAfter(LocalDate.now().minusMonths(1)))
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue((firstList, secondList) ->
                        secondList.size() - firstList.size()))
                .limit(top)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    if (!entry.getValue().isEmpty()) {
                        return entry.getValue().get(0).getUserName();
                    } else {
                        return "";
                    }
                }))
                .values());
    }

    public Map<ActionType, Double> getActionTypePercentage(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, action ->
                        action.getValue().size() * 100.0 / actions.size()));
    }
}
