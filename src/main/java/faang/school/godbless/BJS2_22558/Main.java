package faang.school.godbless.BJS2_22558;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = List.of(
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content #OG2024"),
                new UserAction(1, "Denis", ActionTypes.LIKE, "Content #java"),
                new UserAction(1, "Denis", ActionTypes.SHARE, "Content"),
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content"),
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content"),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content"),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content #kotlin"),
                new UserAction(2, "Max", ActionTypes.SHARE, "Content"),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content"),
                new UserAction(2, "Max", ActionTypes.POST, "Content"),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content"),
                new UserAction(2, "Max", ActionTypes.LIKE, "Content #go"),
                new UserAction(2, "Max", ActionTypes.LIKE, "Content #sumerki"),
                new UserAction(3, "Gosh", ActionTypes.LIKE, "Content #java"),
                new UserAction(3, "Gosh", ActionTypes.LIKE, "Content"),
                new UserAction(4, "Anton", ActionTypes.COMMENT, "Content #sumerki"),
                new UserAction(5, "Maria", ActionTypes.SHARE, "Content"),
                new UserAction(5, "Maria", ActionTypes.SHARE, "Content #kotlin"),
                new UserAction(7, "Katia", ActionTypes.COMMENT, "Content #sumerki"),
                new UserAction(7, "Katia", ActionTypes.POST, "Content"),
                new UserAction(8, "Katia", ActionTypes.POST, "Content #java"),
                new UserAction(9, "Katia", ActionTypes.POST, "Content"),
                new UserAction(10, "Katia", ActionTypes.COMMENT, "Content #bestseller"),
                new UserAction(11, "Katia", ActionTypes.POST, "Content #java"));

        System.out.println(UserAction.getTop10MostActiveUsers(actions));
        System.out.println(UserAction.findTop5PopularThemes(actions));
        System.out.println(UserAction.findTop3UserByComments(actions));
        System.out.println(UserAction.getActionsByPercentage(actions));

    }


}
