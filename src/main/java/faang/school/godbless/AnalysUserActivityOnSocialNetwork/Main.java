package faang.school.godbless.AnalysUserActivityOnSocialNetwork;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.AnalysUserActivityOnSocialNetwork.ActivityAnalysis.top5PopularTopics;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActionList = Arrays.asList(
                new UserAction(1, "petya", "COMMENT", LocalDate.of(2023, 5, 11), "lkvnldn #comit"),
                new UserAction(12, "user2", "LIKE", LocalDate.of(2023, 5, 11), "csdwt"),
                new UserAction(12, "petya", "SHARE", LocalDate.of(2023, 5, 11), "#erw"),
                new UserAction(33, "user4", "LIKE", LocalDate.of(2022, 12, 11), "#comit 345 "),
                new UserAction(1, "petya", "POST", LocalDate.of(2022, 12, 11), "123"),
                new UserAction(44, "user6", "COMMENT", LocalDate.of(2023, 12, 11), "#erw rsrsg"),
                new UserAction(45, "user7", "COMMENT", LocalDate.of(2023, 12, 11), "65 #erw"),
                new UserAction(12, "user2", "COMMENT", LocalDate.of(2023, 12, 11), "This is a #erw #Java123 "),
                new UserAction(1, "petya", "POST", LocalDate.of(2023, 12, 11), "#erw rsrsg"),
                new UserAction(1, "petya", "POST", LocalDate.of(2023, 12, 11), "65 #erw"),
                new UserAction(12, "user2", "COMMENT", LocalDate.of(2023, 12, 11), "This is a #erw #Java123 ")
        );

        List<String> top10ActiveUser = ActivityAnalysis.top10ActiveUser(userActionList);
        System.out.println("Топ 10: " + top10ActiveUser);

        top5PopularTopics(userActionList);

        List<String> top3UsersMostComments = ActivityAnalysis.top3UsersMostComments(userActionList);
        System.out.println("ТОп 3 по количеству комментариев за месяц: " + top3UsersMostComments);

        Map<String, Double> percentAction = ActivityAnalysis.percentAction(userActionList);
        System.out.println(percentAction);
    }


}
