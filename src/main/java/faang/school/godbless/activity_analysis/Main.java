package faang.school.godbless.activity_analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> users = new ArrayList<>();
        String[] tags = new String[]{"#ten", "technologies", "#life", "#someEvent", "#anotherEvent"};
        ActionType[] actionTypes = new ActionType[]{ActionType.POST, ActionType.COMMENT, ActionType.LIKE, ActionType.SHARE};
        for (int i = 0; i < 25; i++) {
            StringBuilder content = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                content.append(tags[(int) (tags.length * Math.random())]).append(", ");
            }
            UserAction userAction = new UserAction((int) (20 * Math.random()), "Random",
                    actionTypes[(int) (actionTypes.length * Math.random())], "Today", content.toString());
            users.add(userAction);
        }

        users.forEach(System.out::println);
        System.out.println(UserActionProcessor.findIdOfTopNMostActiveUsers(users, Arrays.asList(actionTypes), 10));
        System.out.println(UserActionProcessor.findTopNMostDiscussedThemes(users, 5));
        System.out.println(UserActionProcessor.findIdOfTopNMostActiveUsersInComments(users, 5));
        System.out.println(UserActionProcessor.countPercentageOfEachActionType(users, Arrays.asList(actionTypes)));
    }
}
