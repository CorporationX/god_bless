package faang.school.godbless.social_media;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserAnalyticsService {
    public static List<String> getTopActiveUsers(List<UserAction> actions, int limit){
        return actions.stream().map(UserAction::getName).limit(limit).toList();
    }
    public static List<String> getTopTopics(List<UserAction> actions, int limit){
        return actions.stream().map(UserAction::getContent).toList();
    }
    public static List<String> getTopCommenters(List<UserAction> actions, int limit){
        return actions.stream().map(UserAction::getName).toList();
    }
    public static Map<String, Integer> getActionsPercentage(List<UserAction> actions){
        return actions.stream().collect(Collectors.toMap(UserAction::getActionType,
                (action)-> 1 ));
    }

}
