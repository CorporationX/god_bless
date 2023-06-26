package faang.school.godbless;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ActionsAnalyser {
    public List<Integer> getTop10Users(List<UserAction> actions) {
        Map<Integer, Long> userActionCounts = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));
        return userActionCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTop5Topics(List<UserAction> actions) {
        var topTopics = actions.stream()
                .filter(action -> action.getAction() == ActionType.COMMENT || action.getAction() == ActionType.POST)
                .filter(action -> action.getContent() != null && !action.getContent().isBlank())
                .flatMap(action -> findHashtags(action.getContent()).stream())
                .collect(Collectors.groupingBy(topic -> topic, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
        return topTopics;
    }

    private List<String> findHashtags(String content) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");
        Matcher matcher = hashtagPattern.matcher(content);
        List<String> hashtags = new ArrayList<>();
        while (matcher.find()) {
            hashtags.add(matcher.group());
        }
        return hashtags;
    }

    public List<Integer> getTop3Users(List<UserAction> actions) {
        var topUsers = actions.stream()
                .filter(action -> action.getAction() == ActionType.COMMENT)
                .filter(action -> action.getContent() != null && !action.getContent().isBlank())
                .filter(action -> new Date().getTime() - action.getActionDate().getTime() < (30L * 24 * 60 * 60 * 1000))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        return topUsers;
    }

    public Map<ActionType, Double> calculatePercents(List<UserAction> actions) {
        Map<ActionType, Double> result = new HashMap<>();
        actions.stream()
                .filter(action -> action.getContent() != null && !action.getContent().isBlank())
                .collect(Collectors.groupingBy(UserAction::getAction, Collectors.counting()))
                .forEach((key, value) -> result.put(key, (value * 100.0 / actions.size())));
        return result;
    }
}
