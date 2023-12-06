package Analysis_of_user_activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivityAnalysis {
    //Найти топ-10 самых активных пользователей
    public static Map<Integer, List<UserAction>> findTheTop10MostActiveUsers(List<UserAction> userActions) {
        Map<Integer, List<UserAction>> users = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserID));
        Map<Integer, List<UserAction>> topUsers = users.entrySet().stream()
                .sorted((user1, user2) -> user2.getValue().size() - user1.getValue().size())
                .limit(10)
                .collect(Collectors.toMap(key -> key.getKey(),
                        value -> value.getValue()));
        return topUsers;
    }

    //Топ-5 наиболее популярных тем обсуждения
    public static List<String> findTheTop5MostPopularTopics(List<UserAction> userActions) {
        Map<String, Integer> hashtagFrequencyMap = new HashMap<>();
        List<String> listOfAllHashtags = new ArrayList<>();

        userActions.stream()
                .map(userAction -> userAction.getContent())
                .forEach(content -> {
                    char[] chars = content.toCharArray();
                    boolean isWriting = false;
                    List<String> listOfHashtags = new ArrayList<>();
                    String hashtag = "";
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] == '#') {
                            isWriting = true;
                            hashtag += chars[i];
                        } else if (chars[i] != '#' && chars[i] != ' ' && isWriting) {
                            hashtag += chars[i];
                        } else if (chars[i] == ' ' && isWriting) {
                            isWriting = false;
                            listOfHashtags.add(hashtag);
                            hashtag = "";
                        } else if (i == chars.length - 1 && isWriting) {
                            hashtag += chars[i];
                            listOfHashtags.add(hashtag);
                        }
                    }
                    listOfAllHashtags.addAll(listOfHashtags);
                });

        listOfAllHashtags.stream()
                .forEach(hashtag -> {
                    int countOfHashtag = (int) listOfAllHashtags.stream()
                            .filter(thisHashtag -> thisHashtag.equals(hashtag))
                            .count();
                    hashtagFrequencyMap.putIfAbsent(hashtag, countOfHashtag);
                });

        List<String> theMostPopularHashtags = hashtagFrequencyMap.entrySet().stream()
                .sorted((tag1, tag2) -> tag2.getValue() - tag1.getValue())
                .limit(5)
                .map(map -> map.getKey())
                .toList();
        return theMostPopularHashtags;
    }

    //Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц
    public static List<Integer> findTheMostActiveCommentators(List<UserAction> userActions) {
        LocalDate currentDate = LocalDate.now();
        Map<Integer, Integer> allCommentatorsMap = new HashMap<>();

        List<Integer> allCommentsUserID = userActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .filter(userAction -> userAction.getActionDate().getMonth() == currentDate.getMonth())
                .map(userAction -> userAction.getUserID())
                .toList();

        allCommentsUserID.stream()
                .forEach(id -> {
                    int countOfComments = (int) allCommentsUserID.stream()
                            .filter(thisID -> thisID == id)
                            .count();
                    allCommentatorsMap.put(id, countOfComments);
                });
        List<Integer> theMostActiveUsers = allCommentatorsMap.entrySet().stream()
                .sorted((id1, id2) -> id2.getKey() - id1.getKey())
                .limit(3)
                .map(map -> map.getKey())
                .toList();
        return theMostActiveUsers;
    }

    //Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий
    public static Map<ActionType, Double> calculateThePercentageOfActionTypes(List<UserAction> userActions) {
        int allActionsQuantity = userActions.size();
        List<ActionType> actionTypes = Arrays.asList(ActionType.values());
        Map<ActionType, Double> activityPercentageMap = new HashMap<>();
        actionTypes.stream()
                .forEach(actionType -> {
                    int actionsQuantity = (int) userActions.stream()
                            .filter(userAction -> userAction.getActionType() == actionType)
                            .count();
                    double actionPercentage = allActionsQuantity / (double) actionsQuantity;
                    activityPercentageMap.put(actionType, actionPercentage);
                });
        return activityPercentageMap;
    }
}
