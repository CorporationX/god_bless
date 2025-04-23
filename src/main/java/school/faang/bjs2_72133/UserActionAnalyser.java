package school.faang.bjs2_72133;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActionAnalyser {

    public List<String> filterTopByAppearance(List<String> stringsList, int top) {
        return stringsList.stream().sorted((string1, string2) ->
                        (int) (stringsList.stream().filter(a -> a.equals(string2)).count()
                                - stringsList.stream().filter(a -> a.equals(string1)).count()))
                .distinct()
                .limit(top)
                .toList();
    }

    public List<String> topActiveUsers(List<UserAction> userActions, int top) {
        List<String> names =  userActions.stream().map(UserAction::getName).toList();
        return filterTopByAppearance(names, top);
    }

    public List<String> topPopularHashtags(List<UserAction> userActions, int top) {
        String regex = "[^#\\w]";
        List<String> hashtags = userActions.stream()
                .flatMap(action ->
                        Arrays.stream(action.getContent().split(" ")).filter(word -> word.startsWith("#")))
                .map(hashtag -> hashtag.replaceAll(regex, ""))
                .toList();
        return filterTopByAppearance(hashtags, top);
    }

    public List<String> topCommentersLastMonth(List<UserAction> userActions, int top) {
        List<String> commentators = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .map(UserAction::getName)
                .toList();
        return filterTopByAppearance(commentators, top);
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        int percentage = 100;
        Map<String, Double> actionPercentage = new HashMap<>();
        double amountOfActions = userActions.size();
        long amountOfComments = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .count();
        long amountOfPosts = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST))
                .count();
        long amountOfLikes = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.LIKE))
                .count();
        long amountOfShares = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.SHARE))
                .count();

        actionPercentage.put("Comment", amountOfComments / amountOfActions * percentage);
        actionPercentage.put("Post", amountOfPosts / amountOfActions * percentage);
        actionPercentage.put("Like", amountOfLikes / amountOfActions * percentage);
        actionPercentage.put("Share", amountOfShares / amountOfActions * percentage);
        return actionPercentage;
    }
}
