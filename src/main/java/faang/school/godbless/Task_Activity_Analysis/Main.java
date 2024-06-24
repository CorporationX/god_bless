package faang.school.godbless.Task_Activity_Analysis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final List<UserAction> ALL_ACTIONS;

    public static void main(String[] args) {
        System.out.println("top active user's ids: " + Application.findTheMostActiveUsers(ALL_ACTIONS,10));
        System.out.println("top popular hashtags: " + Application.findPopularTopics(ALL_ACTIONS, 4));
        System.out.println("top commentators' ids: " + Application.getTopCommentators(ALL_ACTIONS, 3, 1));
        System.out.println("structure (%) of actions types: " + Application.getStructure(ALL_ACTIONS));
    }

    static {
        List<UserAction> allActions = new ArrayList<>();
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, LocalDate.of(2024,6,2), "#cool"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.comment, LocalDate.of(2024,6,13), "#bad"));
        allActions.add(new UserAction(3, "Jordan",
                UserAction.ActionType.like, LocalDate.of(2024,4,28), "#go"));
        allActions.add(new UserAction(4, "Jake",
                UserAction.ActionType.share, LocalDate.of(2024,6,2), "#cool"));
        allActions.add(new UserAction(5, "Kyle",
                UserAction.ActionType.comment, LocalDate.of(2024,6,3), "#cool"));
        allActions.add(new UserAction(6, "Steven",
                UserAction.ActionType.share, LocalDate.of(2024,3,10), "#go"));
        allActions.add(new UserAction(7, "Mike",
                UserAction.ActionType.comment, LocalDate.of(2024,5,2), "#bad"));
        allActions.add(new UserAction(8, "Jane",
                UserAction.ActionType.share, LocalDate.of(2024,6,20), "#cool"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.comment, LocalDate.of(2024,6,17), "#bad"));
        allActions.add(new UserAction(10, "Derek",
                UserAction.ActionType.share, LocalDate.of(2024,4,24), "..."));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.share, LocalDate.of(2024,6,27), "#cool"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.comment, LocalDate.of(2024,5,2), "nice!"));
        allActions.add(new UserAction(9, "Ian",
                UserAction.ActionType.comment, LocalDate.of(2024,6,2), "#bad"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.comment, LocalDate.of(2024,6,20), "idk"));
        allActions.add(new UserAction(2, "Ian",
                UserAction.ActionType.share, LocalDate.of(2024,3,21), "no"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.share, LocalDate.of(2024,4,12), "#today"));
        allActions.add(new UserAction(11, "Jo",
                UserAction.ActionType.like, LocalDate.of(2024,6,12), "java"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.comment, LocalDate.of(2024,6,28), "java"));
        allActions.add(new UserAction(2, "John",
                UserAction.ActionType.post, LocalDate.of(2024,5,2), "#apple"));
        allActions.add(new UserAction(1, "Alex",
                UserAction.ActionType.like, LocalDate.of(2024,6,20), "#today"));
        ALL_ACTIONS = Collections.unmodifiableList(allActions);
    }

}
