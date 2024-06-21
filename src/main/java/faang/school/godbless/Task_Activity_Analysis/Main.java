package faang.school.godbless.Task_Activity_Analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final List<UserAction> ALL_ACTIONS;

    public static void main(String[] args) {
        //task1
        System.out.println(Application.findTheMostActiveUsers(ALL_ACTIONS));

    }

    static {
        List<UserAction> allActions = new ArrayList<>();
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(3, "Jordan",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(4, "Jake",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(5, "Kyle",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(6, "Steven",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(7, "Mike",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(8, "Jane",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(10, "Derek",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(2, "Ian",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, "01.01.01", "cool"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.comment, "01.01.01", "cool"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.post, "01.01.01", "cool"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.like, "01.01.01", "cool"));
        ALL_ACTIONS = Collections.unmodifiableList(allActions);
    }

}
