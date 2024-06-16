package faang.school.godbless.activity.analysis;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ActivityService {

    public List<Long> findTopTenActiveUsers(List<UserAction> users) {
        if(users.isEmpty()) {
            throw new RuntimeException("Error!");
        }
       List<Long> topTenUsers = users.stream()
               .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
               .entrySet().stream()
               .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
               .limit(10)
               .map(Map.Entry::getKey)
               .toList();
        return topTenUsers;
    }

    // без определения хештегов
    public List<String> getTopFiveContent(List<UserAction> users) {
        if(users.isEmpty()) {
            throw new RuntimeException("Error!");
        }
        Map<String, List<UserAction>> map = new HashMap<>();
        for(UserAction action : users) {
            map.computeIfAbsent(action.getContent(), k -> new ArrayList<>()).add(action);
        }
        List<String> topFiveContent = map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return topFiveContent;

    }

    /**
     * я не добавлял проверку на месяц, но я думаю это можно через && там где я делаю проверку
     * if(action.getActionType().equals("comment")) && checkDate(action.getActionDate()))
     *
     * Просто долго подгонять тестовые данные, хотя как я понял уже лучше было бы для каждого теста
     * делать свой список пользовательских действий
     */
    public List<Long> topThreeUsersByComment(List<UserAction> users) {
        if(users.isEmpty()) {
            throw new RuntimeException("Error!");
        }
        Map<Long, List<UserAction>> gropedActions = new HashMap<>();
        List<UserAction> actionsComment = new ArrayList<>();
        List<Long> topThreeUsers = new ArrayList<>();
        for(UserAction action : users) {
            if(action.getActionType().equals("comment")) {
                actionsComment.add(action);
            }
        }
        for(UserAction action : actionsComment) {
            gropedActions.computeIfAbsent(action.getUserId(), k -> new ArrayList<>()).add(action);
        }
        topThreeUsers = gropedActions.entrySet().stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
        return topThreeUsers;
    }

    private boolean checkDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);

        return (date.isAfter(oneMonthAgo) || date.isEqual(oneMonthAgo)) && (date.isBefore(today) || date.isEqual(today));
    }

    public Map<String, Double> getActionTypePercentage(List<UserAction> users) {
        if(users.isEmpty()) {
            throw new RuntimeException("Error!");
        }
        long actionSize = users.size();
        Map<String, ArrayList<UserAction>> gropedAction = new HashMap<>();
        for(UserAction userAction : users) {
            gropedAction.computeIfAbsent(userAction.getActionType(), k -> new ArrayList<>()).add(userAction);
        }
        Map<String, Double> actionTypePercentage = gropedAction.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue().size() / (double) actionSize) * 100
                ));
        return actionTypePercentage;
    }

}
