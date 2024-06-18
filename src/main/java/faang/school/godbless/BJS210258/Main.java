package faang.school.godbless.BJS210258;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = GetRandomActionsList.generateUserActions(100);
        UserStatistics statistics = new UserStatistics();

        System.out.println("% ACTIONS:");
        System.out.println(statistics.getPercentOfActions(userActions)+"\n");
        System.out.println("TRENDS WORDS:");
        System.out.println(statistics.getListOfTrends(userActions, 3)+"\n");
        System.out.println("TOP 3 USERS:");
        System.out.println(statistics.getTopNUsersByCommentByDate(userActions,3, 1)+"\n");
        System.out.println("TOP 10 USERS:");
        System.out.println(statistics.getTopNUsers(userActions,10)+"\n");

    }


}
