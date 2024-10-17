package school.faang.userAcrion;

import java.util.List;
import java.util.Map;

public class UserActionAnalyzer {


    public static List<String> topActiveUsers (List<UserAction> userActions) {
       return userActions.stream().filter(e -> e.getActionType().equals("post")).map(UserAction::getName).toList();
    }

    public static List<String> topPopularHashtags (List<UserAction> userActions) {
        return userActions.stream().map(UserAction::getContent).filter(content -> content.startsWith("#")).toList();
    }

    public static List<String> topCommentersLastMonth (List<UserAction> userActions) {
        return userActions.stream().filter(e -> e.getActionType().equals("comment")).map(UserAction::getName).toList();
    }

    public static Map<String, Double> actionTypePercentages (List<UserAction> userActions){
        double posts = userActions.stream().filter(e -> e.getActionType().equals("post")).count();
        double comments = userActions.stream().filter(e -> e.getActionType().equals("comment")).count();
        double likes = userActions.stream().filter(e -> e.getActionType().equals("like")).count();
        double shares = userActions.stream().filter(e -> e.getActionType().equals("share")).count();

        double total = posts + comments + likes + shares;

        Map<String, Double> result = Map.of("posts", posts / total * 100, "comments", comments / total * 100, "likes", likes / total * 100, "shares", shares / total * 100);

        return result;

    }

}
