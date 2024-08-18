package faang.school.godbless.AnalyzeSocialActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new UserAction("1", "Ivan", ActionType.POST, LocalDate.now(), "The first post #test"));
        actions.add(new UserAction("2", "Eva", ActionType.COMMENT, LocalDate.now().minusDays(1), "The first comment #test"));
        actions.add(new UserAction("1", "Ivan", ActionType.LIKE, LocalDate.now()));
        actions.add(new UserAction("3", "Maria", ActionType.SHARE, LocalDate.now(), "The first  share! #likecatshare"));
        actions.add(new UserAction("1", "Ivan", ActionType.COMMENT, LocalDate.now().minusDays(15), "Thanks for sharing! #likecatshare"));
        actions.add(new UserAction("2", "Eva", ActionType.POST, LocalDate.now().minusDays(2), "Another post about #test"));
        actions.add(new UserAction("4", "Sergey", ActionType.COMMENT, LocalDate.now().minusDays(5), "Both #test and #likecatshare"));
        actions.add(new UserAction("1", "Ivan", ActionType.SHARE, LocalDate.now().minusDays(3), "The last one #test"));

        List<String> top10ActiveUsers = SocialMediaAnalytics.findTop10ActiveUsers(actions);
        List<String> top5Hashtags = SocialMediaAnalytics.findTop5Hashtags(actions);
        List<String> top3Commenters = SocialMediaAnalytics.findTop3CommentersInLastMonth(actions);
        Map<String, Double> actionTypePercentages = SocialMediaAnalytics.calculateActionTypePercentages(actions);

        System.out.println("Top 10 Active Users: " + top10ActiveUsers);
        System.out.println("Top 5 Hashtags: " + top5Hashtags);
        System.out.println("Top 3 Commenters in Last Month: " + top3Commenters);
        System.out.println("Action Type Percentages: " + actionTypePercentages);
    }
}
