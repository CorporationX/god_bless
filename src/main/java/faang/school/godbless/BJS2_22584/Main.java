package faang.school.godbless.BJS2_22584;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new UserAction(1, "Alice", "post",
                LocalDate.of(2024, 8, 19), "Loving the new features of #Java and #StreamAPI!"));
        userActions.add(new UserAction(1, "Alice", "comment",
                LocalDate.of(2024, 7, 20), "I agree with #Java, but #Python is also great."));
        userActions.add(new UserAction(2, "Bob", "comment",
                LocalDate.of(2024, 8, 21), "Check out my new blog post!"));
        userActions.add(new UserAction(2, "Bob", "comment",
                LocalDate.of(2024, 8, 22), "Discussing #AI and #python today."));
        userActions.add(new UserAction(2, "Bob", "post",
                LocalDate.of(2024, 8, 23), "I prefer #MachineLearning over #python."));
        userActions.add(new UserAction(3, "Charlie", "comment",
                LocalDate.of(2024, 8, 24), "Charlie commented on Bob's post #enjoying"));
        System.out.println("Top 10 active users:");
        ActivityAnalysisProcess.findTop10ActiveUsers(userActions).forEach(System.out::println);

        System.out.println("Top 5 popular themes");
        ActivityAnalysisProcess.findTop5PopularThemes(userActions).forEach(System.out::println);

        System.out.println("Top 3 commenters last month:");
        ActivityAnalysisProcess.findTop3CommentersLastMonth(userActions).forEach(System.out::println);

        System.out.println("Percentage of actions for each type of action:");
        ActivityAnalysisProcess.countPercentOfActionTypes(userActions).forEach((actionType, percent) ->
                System.out.println(actionType + " - " + percent + "%"));
    }
}
