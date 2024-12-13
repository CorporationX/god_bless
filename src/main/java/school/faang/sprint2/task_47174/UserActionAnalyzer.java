package school.faang.sprint2.task_47174;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserActionAnalyzer {

    public List<String> topActiveUsers(List<UserAction> actions) {
        Map<String, Integer> nameToActions = new HashMap<>();
        actions.stream()
                .forEach((action) -> nameToActions.merge(action.getName(), 1, Integer::sum));

        return nameToActions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map((user) -> user.getKey())
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        Map<String, Integer> hashtags = new HashMap<>();
        Pattern hashtagPattern = Pattern.compile("#\\w+");

        actions.stream()
                .forEach((action) -> {
                    Matcher matcher = hashtagPattern.matcher(action.getText());
                    if (matcher.find()) {
                        String hashtag = matcher.group();
                        hashtags.merge(hashtag, 1, Integer::sum);
                    }
                });

        return hashtags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map((tag) -> tag.getKey())
                .toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<String, Integer> nameToComments = new HashMap<>();

        actions.stream()
                .filter((action) -> action.getDate().isAfter(LocalDate.now().minusMonths(1)))
                .forEach((action) -> nameToComments.merge(action.getName(), 1, Integer::sum));

        return nameToComments.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map((user) -> user.getKey())
                .toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Double> typePercentages = new HashMap<>();

        actions.stream()
                .forEach((action) -> typePercentages.merge(action.getActionType(), 1.00, Double::sum));

        int actionsNumber = actions.size();
        typePercentages.entrySet().stream()
                .forEach((type) -> typePercentages.put(type.getKey(), (type.getValue() / actionsNumber) * 100));

        return typePercentages;
    }
}
