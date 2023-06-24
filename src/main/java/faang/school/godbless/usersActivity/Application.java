package faang.school.godbless.usersActivity;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private Map<Integer, User> allUsers = new HashMap<>();

    public List<User> topTenUsers(List<UserAction> userActions){
        Map<Integer, List<UserAction>> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getIdUser));
        List<User> topUsers = users.entrySet().stream()
                .sorted((user, user1) -> user1.getValue().size() - user.getValue().size())
                .limit(10)
                .map(Map.Entry::getKey)
                .map(userID -> allUsers.get(userID))
                .toList();
        return topUsers;
    }

    public List<String> topFiveThemes(List<UserAction> userActions){
        return userActions.stream()
                .filter(userAction -> {
                    return userAction.getActionType().equals(ActionType.COMMENT) ||
                            userAction.getActionType().equals(ActionType.POST);
                })
                .map(UserAction::getContent)
                .flatMap(line -> Arrays.stream(line.split("\\s")))
                .filter(word -> word.matches("#\\w+"))
                .collect(Collectors.groupingBy(word -> word))
                .entrySet().stream()
                .sorted((entry, entry1) -> entry1.getValue().size() - entry.getValue().size())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<User> topThreeUsers(List<UserAction> userActions){
         return userActions.stream().
                filter(userAction -> {
                    Date monthAgo = new Date();
                    LocalDate.from(monthAgo.toInstant().minusSeconds(2592000));
                    return userAction.getActionDate().after(monthAgo);
                })
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getIdUser))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size())
                .limit(3)
                .map(entry -> allUsers.get(entry.getKey()))
                .collect(Collectors.toList());
    }

    public void percentOfActions(List<UserAction> userActions){
        long allActions = userActions.size();
        long likes = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.LIKE))
                .count();
        long posts = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST))
                .count();
        long comments = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .count();
        long shares = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.SHARE))
                .count();
        System.out.println("Процент лайков от всех действий = " + (allActions*100/likes) + "%");
        System.out.println("Процент постов от всех действий = " + (allActions*100/posts) + "%");
        System.out.println("Процент комментариев от всех действий = " + (allActions*100/comments) + "%");
        System.out.println("Процент передачи ссылок от всех действий = " + (allActions*100/shares) + "%");
    }
}
