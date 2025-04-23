package school.faang.analysisuser;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public List<String> toActiveUser(List<UserAction> users, int top) {
        Map<String, List<UserAction>> groupByName = users.stream()
                .collect(Collectors.groupingBy(UserAction::getName));

        return groupByName.entrySet().stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public List<String> toCommentsUser(List<UserAction> users, int top) {
        List<UserAction> usersByComments = users.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.COMMENT))
                .toList();

        Map<String, List<UserAction>> groupByName = usersByComments.stream()
                .collect(Collectors.groupingBy(UserAction::getName));

        return groupByName.entrySet().stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public void analyseData(List<UserAction> users) {
        int comments = users.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.COMMENT))
                .toList().size();

        int posts = users.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.POST))
                .toList().size();

        int likes = users.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.LIKE))
                .toList().size();

        int shares = users.stream()
                .filter(user -> Objects.equals(user.getActionType(), ActionType.SHARE))
                .toList().size();

        double commentPercentage = ((double) comments / users.size()) * 100;
        double postPercentage = ((double) posts / users.size()) * 100;
        double likePercentage = ((double) likes / users.size()) * 100;
        double sharePercentage = ((double) shares / users.size()) * 100;

        System.out.printf(
                "Доля постов %.2f%%\n" +
                        "Доля лайков %.2f%%\n" +
                        "Доля комментов %.2f%%\n" +
                        "Доля репостов %.2f%%",
                postPercentage,
                likePercentage,
                commentPercentage,
                sharePercentage
        );
    }
}