package faang.school.godbless.modul2.useractivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserActionService userActionService = new UserActionService();
        List<UserAction> userActions = getUserActions();

        //1.
        System.out.println("Top 10 users by total actions:");
        System.out.println("  " + userActionService.getTop10ActiveUsers(userActions));

        //2.
        System.out.println("\n" + "Top 5 most popular discussion topics:");
        System.out.println("  " + userActionService.getTop5Topic(userActions));

        //3.
        System.out.println("\n" + "Top 3 last mount most active commentators:");
        System.out.println("  " + userActionService.getTop3ActiveCommentators(userActions));

        //4.
        System.out.println("\n" + "Percentage for each type of action:");
        System.out.println("  " + userActionService.getAnalytics(userActions) + "\n");

        //ActiveUsersInfo
        userActionService.printActiveUsersInfo(userActions);
    }

    private static List<UserAction> getUserActions() {
        List<UserAction> userActions = new ArrayList<>();

        userActions.add(new UserAction(1L, "Anna", ActionType.POST, LocalDateTime.now(), "Just finished reading the #Snowman!"));
        userActions.add(new UserAction(1L, "Anna", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(1L, "Anna", ActionType.LIKE, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(1L, "Anna", ActionType.COMMENT, LocalDateTime.now(), "The #weather is bad today!"));
        userActions.add(new UserAction(1L, "Anna", ActionType.LIKE, LocalDateTime.now(), "The #weather is bad today!"));
        userActions.add(new UserAction(2L, "Maria", ActionType.COMMENT, LocalDateTime.now(), "Amazing #weather today!"));
        userActions.add(new UserAction(2L, "Maria", ActionType.POST, LocalDateTime.now(), "Enjoying a sunny day! #weather"));
        userActions.add(new UserAction(3L, "John", ActionType.POST, LocalDateTime.now().minusMonths(6), "Started learning #Java!"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now().minusMonths(5), "I have a headache...#Java"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now().minusMonths(4), "I have a headache...#Java"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now().minusMonths(3), "I have a headache...#Java"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "I have a headache...#Java"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now().minusMonths(1), "I have a headache...#Java"));
        userActions.add(new UserAction(3L, "John", ActionType.COMMENT, LocalDateTime.now(), "I have a headache...#Java"));
        userActions.add(new UserAction(4L, "Lucy", ActionType.POST, LocalDateTime.now(), "Learning new recipes.#baking"));
        userActions.add(new UserAction(4L, "Lucy", ActionType.COMMENT, LocalDateTime.now(), "Great post!#baking"));
        userActions.add(new UserAction(4L, "Lucy", ActionType.COMMENT, LocalDateTime.now(), "Great post!"));
        userActions.add(new UserAction(4L, "Lucy", ActionType.POST, LocalDateTime.now(), "#Baking a cake today!"));
        userActions.add(new UserAction(5L, "Peter", ActionType.COMMENT, LocalDateTime.now(), "Interesting perspective."));
        userActions.add(new UserAction(5L, "Peter", ActionType.COMMENT, LocalDateTime.now(), "Interesting perspective."));
        userActions.add(new UserAction(5L, "Peter", ActionType.COMMENT, LocalDateTime.now(), "Interesting perspective."));
        userActions.add(new UserAction(5L, "Peter", ActionType.COMMENT, LocalDateTime.now(), "Interesting perspective."));
        userActions.add(new UserAction(5L, "Peter", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(6L, "James", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(6L, "James", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(7L, "Kate", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(7L, "Kate", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(8L, "Mark", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(8L, "Mark", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(9L, "Emma", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(9L, "Emma", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(10L, "Sarah", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));
        userActions.add(new UserAction(10L, "Sarah", ActionType.COMMENT, LocalDateTime.now(), "Can't wait for the #weekend."));
        userActions.add(new UserAction(11L, "David", ActionType.POST, LocalDateTime.now(), "Finished the #marathon!"));

        return userActions;
    }
}
