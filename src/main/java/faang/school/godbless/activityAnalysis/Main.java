package faang.school.godbless.activityAnalysis;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Alex", ActionType.COMMENT, "Some comment"),
                new UserAction(2, "Tom", ActionType.LIKE, ""),
                new UserAction(3, "Mike", ActionType.POST, "Some post"),
                new UserAction(4, "Alex", ActionType.COMMENT, "#Somecomment"),
                new UserAction(5, "Katy", ActionType.LIKE, ""),
                new UserAction(6, "Tom", ActionType.SHARE, "#Somepost"),
                new UserAction(7, "Alex", ActionType.COMMENT, "Some comment"),
                new UserAction(8, "Mark", ActionType.LIKE, ""),
                new UserAction(9, "Tom", ActionType.POST, "#Somepost"),
                new UserAction(10, "Emily", ActionType.LIKE, ""),
                new UserAction(5, "Katy", ActionType.LIKE, ""),
                new UserAction(4, "Alex", ActionType.COMMENT, "#Somecomment"),
                new UserAction(4, "Alex", ActionType.COMMENT, "#Somecomment"));

        ActionAnalyzer actionAnalyzer = new ActionAnalyzer();

        System.out.println(actionAnalyzer.topTenActiveUsers(userActions));

        System.out.println(actionAnalyzer.topFivePopularThemes(userActions));

        System.out.println(actionAnalyzer.topThreeCommenters(userActions));

        actionAnalyzer.getActionTypePercentage(userActions)
                .forEach((key, value) -> System.out.println(key.toString() + " - " + String.format("%.3f", value) + "%"));
    }
}
