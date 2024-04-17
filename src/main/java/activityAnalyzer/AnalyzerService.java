package activityAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzerService {
    public List<Integer> findTopTenMostActiveUsers(List<UserAction> userActions) {
        Map<Integer, List<UserAction>> userActionByIdUser = new HashMap<>();
        userActions.forEach(userAction -> {
            if (!userActionByIdUser.containsKey(userAction.getId()))
                userActionByIdUser.put(userAction.getId(), new ArrayList<>());
            userActionByIdUser.get(userAction.getId()).add(userAction);
        });
        return userActionByIdUser.entrySet().stream()
                .sorted()
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> findTopFiveTopicsByHashtag(List<UserAction> userActions) {
        Map<String, List<UserAction>> popularHashtags = new HashMap<>();
        userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post")
                        || userAction.getActionType().equals("comment"))
                .forEach(userAction -> {
                    List<String> content = new ArrayList<>(Arrays.asList(userAction.getContent().split(" ")));
                    content.stream()
                            .filter(cont -> cont.charAt(0) == '#')
                            .forEach(hashtag -> {
                                if (!popularHashtags.containsKey(hashtag)) {
                                    popularHashtags.put(hashtag, new ArrayList<>());
                                }
                                popularHashtags.get(hashtag).add(userAction);
                            });
                });
        return popularHashtags.entrySet().stream()
                .sorted()
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> findTopThreeUsersByComments(List<UserAction> userActions) {
        Map<UserAction, List<String>> commByUserActions = new HashMap<>();
        userActions.stream()
                .forEach(userAction -> {
                    if (!commByUserActions.containsKey(userAction))
                        commByUserActions.put(userAction, new ArrayList<>());
                    commByUserActions.get(userAction).add(userAction.getActionType());
                });
        return commByUserActions.entrySet().stream()
                .sorted()
                .limit(3)
                .map(entry -> entry.getKey().getId())
                .toList();
    }

    public Map<String, Double> countPercentByAction(List<UserAction> userActions) {
        Map<String, List<UserAction>> userActionMapByType = new HashMap<>();
        userActions.stream()
                .forEach(userAction -> {
                    if (!userActionMapByType.containsKey(userAction.getActionType())) {
                        userActionMapByType.put(userAction.getActionType(), new ArrayList<>());
                    }
                    userActionMapByType.get(userAction.getActionType()).add(userAction);

                });
        Map<String, Double> result = new HashMap<>();
        userActionMapByType.entrySet().stream()
                .forEach(entry -> result.put(entry.getKey(), (entry.getValue().size() / (double) userActions.size()) * 100));

        return result;
    }
}
