package faang.school.godbless.BJS210258;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserStatistics {


    public List<Integer> topTenUsers(List<UserAction> userActionList) {
        if (userActionList == null) {
            throw new IllegalArgumentException("List is Null");
        }
        Map<Integer, Long> countUserActionsMap = userActionList.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting())
                );
        Map<Integer, Long> topTenMap = countUserActionsMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return topTenMap.keySet().stream().toList();
    }


    public List<String> topFiveTrends(List<UserAction> userActionList) {
        if (userActionList == null) {
            throw new IllegalArgumentException("List is Null");
        }
        Map<String, Long> trendsWordMap = userActionList.stream()
                .filter(userAction -> !userAction.getActionType().equals(Actions.LIKE))
                .map(userAction -> trendWord(userAction.getContent())).filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        Map<String, Long> topFiveMap = trendsWordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        return topFiveMap.keySet().stream().toList();
    }

    private String trendWord(String line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Line is null");
        }
        int startIndex = line.indexOf('#');
        if (startIndex == -1) {
            return "";
        }
        int lastIndex = line.indexOf(' ', startIndex);
        return line.substring(startIndex + 1, lastIndex != -1 ? lastIndex : line.length());
    }

    public List<Integer> topThreeUsers(List<UserAction> userActionList) {
        if (userActionList == null) {
            throw new IllegalArgumentException("List is Null");
        }
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        Map<Integer, Long> countUserCommentMap = userActionList.stream()
                .filter(userAction -> userAction.getActionType().equals(Actions.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting())
                );
        Map<Integer, Long> topThreeMap = countUserCommentMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return topThreeMap.keySet().stream().toList();
    }

    public Map<Actions, Double> percentOfActions(List<UserAction> userActionList) {
        if (userActionList == null) {
            throw new IllegalArgumentException("List is Null");
        }
        int sizeOfList = userActionList.size();
        Map<Actions, Double> result = userActionList.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (100.0 * entry.getValue()) / sizeOfList

                ));
        return result;
    }
}
