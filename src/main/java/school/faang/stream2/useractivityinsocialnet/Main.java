package school.faang.stream2.useractivityinsocialnet;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UsersByID usersByID = new UsersByID();

        List<User> userList = Arrays.asList(
                new User("Alice"),
                new User("Patrick"),
                new User("Angela")
        );

        usersByID.setUsers(userList);

        List<UserAction> usersActions = Arrays.asList(
                new UserAction(usersByID, 1, ActionType.POST, "Hello, I`m here!"),
                new UserAction(usersByID, 2, ActionType.POST, "Here is my new puppy!"),
                new UserAction(usersByID, 2, ActionType.POST, "This is my dog!"),
                new UserAction(usersByID, 3, ActionType.POST, "I`ve made a cake!"),
                new UserAction(usersByID, 1, ActionType.COMMENT, "Your cake is gorgeous"),
                new UserAction(usersByID, 1, ActionType.COMMENT, "Your dog is super funny"),
                new UserAction(usersByID, 3, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(1)),
                new UserAction(usersByID, 3, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(2)),
                new UserAction(usersByID, 3, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(2)),
                new UserAction(usersByID, 2, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(1)),
                new UserAction(usersByID, 2, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(3)),
                new UserAction(usersByID, 1, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(3)),
                new UserAction(usersByID, 1, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(2)),
                new UserAction(usersByID, 1, ActionType.LIKE, "Liked post of" + usersByID.getUsers().get(2)),
                new UserAction(usersByID, 1, ActionType.SHARE, "I`d love a cake like this for my wedding!")
        );

        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer(usersByID, usersActions);

        int limitNumber = 3;
        System.out.println("Top " + limitNumber + " ActiveUsers, who are sharing posts: "
                + userActionAnalyzer.getTopActiveUsers(ActionType.SHARE, limitNumber));
        System.out.println("Top " + limitNumber + " ActiveUsers, who are making posts: "
                + userActionAnalyzer.getTopActiveUsers(ActionType.POST, limitNumber));
        System.out.println("Top " + limitNumber + " ActiveUsers, who are liking posts: "
                + userActionAnalyzer.getTopActiveUsers(ActionType.LIKE, limitNumber));
        System.out.println("Top " + limitNumber + " ActiveUsers, who are commenting posts: "
                + userActionAnalyzer.getTopActiveUsers(ActionType.COMMENT, limitNumber));
    }
}
