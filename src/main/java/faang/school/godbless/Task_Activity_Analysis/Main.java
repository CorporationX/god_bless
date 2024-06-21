package faang.school.godbless.Task_Activity_Analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final List<UserAction> ALL_ACTIONS;

    public static void main(String[] args) {
        System.out.println("top 10 active user's ids: " + Application.findTheMostActiveUsers(ALL_ACTIONS));
        System.out.println("top 5 popular hashtags: " + Application.findPopularTopics(ALL_ACTIONS));

    }

    static {
        List<UserAction> allActions = new ArrayList<>();
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "#cool"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.share, "01.01.01", "#bad"));
        allActions.add(new UserAction(3, "Jordan",
                UserAction.ActionType.share, "01.01.01", "#go"));
        allActions.add(new UserAction(4, "Jake",
                UserAction.ActionType.share, "01.01.01", "#cool"));
        allActions.add(new UserAction(5, "Kyle",
                UserAction.ActionType.share, "01.01.01", "#cool"));
        allActions.add(new UserAction(6, "Steven",
                UserAction.ActionType.share, "01.01.01", "#go"));
        allActions.add(new UserAction(7, "Mike",
                UserAction.ActionType.share, "01.01.01", "#bad"));
        allActions.add(new UserAction(8, "Jane",
                UserAction.ActionType.share, "01.01.01", "#cool"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.share, "01.01.01", "#bad"));
        allActions.add(new UserAction(10, "Derek",
                UserAction.ActionType.share, "01.01.01", "..."));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "#cool"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "nice!"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.share, "01.01.01", "#bad"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "idk"));
        allActions.add(new UserAction(2, "Ian",
                UserAction.ActionType.share, "01.01.01", "no"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "#today"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "java"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.comment, "01.01.01", "java"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.post, "01.01.01", "#apple"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.like, "01.01.01", "#today"));
        ALL_ACTIONS = Collections.unmodifiableList(allActions);
    }

}
