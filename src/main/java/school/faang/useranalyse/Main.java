package school.faang.useranalyse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInitializer initializer = new UserInitializer();
        List<UserAction> userActions = initializer.getActions();

        System.out.println("Top 3 active users: " + UserActionAnalyzer.findTopActiveUsers(userActions));
        System.out.println("Top 5 popular actions: " + UserActionAnalyzer.findTopPopularActions(userActions));
        System.out.println("Top 3 users with most comments: " + UserActionAnalyzer.findUsersWithMostCommentLastMonth(userActions));
        System.out.println("Actions percentage: " + UserActionAnalyzer.calculateActionPercentage(userActions));
    }
}
