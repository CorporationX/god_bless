package faang.school.godbless.BJS210258;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserStatistics {

    public List<Integer> getTopNUsers(List<UserAction> userActionList, int userNumber) {
        validateInputs(userActionList, userNumber);
        Map<Integer, Long> countUserActionsMap = getCountUserActionsMap(userActionList);
        return getIdOfNActiveUsers(countUserActionsMap, userNumber);
    }
    private Map<Integer, Long> getCountUserActionsMap (List<UserAction> userActionList) {
        return userActionList.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting())
                );
    }
    private List<Integer> getIdOfNActiveUsers (Map<Integer, Long> mapOfActiveUsers, int userNumber) {
        return mapOfActiveUsers.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(userNumber)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                )).keySet().stream().toList();
    }
    public List<String> getListOfTrends(List<UserAction> userActionList, int trendsNumber) {
        validateParameters(userActionList, trendsNumber);
        Map<String, Long> trendsWordMap = getMapOfTrends(userActionList);
        return getListOfNTrends(trendsWordMap, trendsNumber);
    }
    private Map<String, Long> getMapOfTrends(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(userAction -> !userAction.getActionType().equals(Actions.LIKE))
                .map(userAction -> trendWord(userAction.getContent())).filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
    }
    private List<String> getListOfNTrends(Map<String, Long> trendsWordMap, int trendsNumber) {
        return trendsWordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(trendsNumber)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ))
                .keySet().stream().toList();
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
    public List<Integer> getTopNUsersByCommentByDate(List<UserAction> userActionList, int numberOfUsers, int monthsBack) {
       validateInputs(userActionList, numberOfUsers, monthsBack);
        LocalDate monthsAgo = LocalDate.now().minusMonths(monthsBack);
        Map<Integer, Long> countUserCommentMap = getCountUsersCommentsMapByDate(userActionList, monthsAgo);
        return findTopNUsers(countUserCommentMap, numberOfUsers);
    }
    private Map<Integer, Long> getCountUsersCommentsMapByDate (List<UserAction> userActionList, LocalDate monthsAgo) {
        return userActionList.stream()
                .filter(userAction -> userAction.getActionType().equals(Actions.COMMENT))
                .filter(userAction -> userAction.getActionDate().isAfter(monthsAgo))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting())
                );
    }
    private List<Integer> findTopNUsers(Map<Integer, Long> countUserCommentMap, int numberOfUsers) {
        return countUserCommentMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(numberOfUsers)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                )).keySet().stream().toList();
    }
    public Map<Actions, Double> getPercentOfActions(List<UserAction> userActionList) {
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
    private void validateInputs(List<UserAction> userActionList, int userNumbers) {
        if (userActionList == null) {
            throw new IllegalArgumentException("Action list can not be null");
        }
        if (userNumbers <= 0) {
            throw new IllegalArgumentException("The number of top users must be greater than 0");
        }
    }
    private void validateInputs(List<UserAction> userActionList, int userNumbers, int monthsBack) {
        if (userActionList == null) {
            throw new IllegalArgumentException("Action list can not be null");
        }
        if (userNumbers <= 0) {
            throw new IllegalArgumentException("The number of top users must be greater than 0");
        }
        if (monthsBack < 0) {
            throw new IllegalArgumentException("Months back must be non-negative");
        }
    }
    private void validateParameters(List<UserAction> userActionList, int trendsNumber) {
        if (userActionList == null) {
            throw new IllegalArgumentException("Action list can not be null");
        }
        if (trendsNumber <= 0) {
            throw new IllegalArgumentException("The number of top trends must be greater than 0");
        }
    }
}
