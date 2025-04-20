package school.faang.bjs2_70890;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class UserActionAnalyzer {

    public List<User> getTopActiveUsers(List<UserAction> userActions, int qty) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt((Map.Entry<Integer, List<UserAction>> entry) ->
                        entry.getValue().size()).reversed())
                .limit(qty)
                .map(entry -> new User(entry.getKey(), entry.getValue().get(0).getName()))
                .toList();
    }

//    public List<String> getTopDiscussedTopics(List<UserAction> userActions) {
//
//    }
}
