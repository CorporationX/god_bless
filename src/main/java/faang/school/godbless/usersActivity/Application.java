package faang.school.godbless.usersActivity;

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
}
