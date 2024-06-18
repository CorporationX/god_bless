package faang.school.godbless.analise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceAction {

    public List<UserAction> searchTopTenActiveUsers(List<UserAction> usersAction) {
        if (usersAction.isEmpty() || usersAction == null) {
            throw new IllegalArgumentException(
                    "ServiceActon class method searchTopTenActiveUsers apply empty or non-existent List");
        }
        return usersAction.stream()
                .sorted(Comparator.comparing(act -> act.getActionType().values().size()))
                .limit(10)
                .toList();
    }

    public List<UserAction> searchTopFivePopularTopic(List<UserAction> usersAction) {
        if (usersAction.isEmpty() || usersAction == null) {
            throw new IllegalArgumentException(
                    "ServiceActon class method searchTopFivePopularTopic apply empty or non-existent List");
        }
        return usersAction.stream()
                .sorted((act1, act2) -> Integer.compare(
                        (int) act1.getActionType().values().stream()
                                .flatMap(List::stream)
                                .filter(str -> str.startsWith("#"))
                                .count(),
                        (int) act2.getActionType().values().stream()
                                .flatMap(List::stream)
                                .filter(str -> str.startsWith("#"))
                                .count()))
                .limit(5)
                .toList();
    }

    public List<UserAction> searchTopThreeCommentators(List<UserAction> usersAction) {
        if (usersAction.isEmpty() || usersAction == null) {
            throw new IllegalArgumentException(
                    "ServiceActon class method searchTopThreeCommentators apply empty or non-existent List");
        }
        return usersAction.stream()
                .sorted((act1, act2) -> Integer.compare(
                        (int) act1.getActionType().entrySet().stream()
                                .filter(entry -> entry.getKey().equals("comment"))
                                .mapToLong(entry -> entry.getValue().size())
                                .sum(),
                        (int) act2.getActionType().entrySet().stream()
                                .filter(entry -> entry.getKey().equals("comment"))
                                .mapToLong(entry -> entry.getValue().size())
                                .sum()))
                .limit(3)
                .toList();
    }

    public Map<String, Double> calculatePercentageActions(List<UserAction> usersAction) {
        if (usersAction.isEmpty() || usersAction == null) {
            throw new IllegalArgumentException(
                    "ServiceActon class method calculatePercentageActions apply empty or non-existent List");
        }
        int sizeAllListInMap = usersAction.stream()
                .flatMap(act -> act.getActionType().values().stream())
                .mapToInt(List::size)
                .sum();
        return usersAction.stream()
                .flatMap(act -> act.getActionType().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (double) entry.getValue().size() / sizeAllListInMap / 100));
    }
}
