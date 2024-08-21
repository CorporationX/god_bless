package faang.school.godbless.BJS222743;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<UserAction> actions = List.of(
                new UserAction(1L, "Paul Pogba", "post", LocalDate.of(2024, 8, 1), "New adidas shoes! #adidas #football"),
                new UserAction(2L, "Cristiano Ronaldo", "comment", LocalDate.of(2024, 8, 2), "Great match yesterday! #football"),
                new UserAction(3L, "Elon Musk", "post", LocalDate.of(2024, 8, 3), "Launching a new rocket tomorrow! #SpaceX"),
                new UserAction(4L, "Bill Gates", "share", LocalDate.of(2024, 8, 4), "Interesting article on AI #technology"),
                new UserAction(5L, "Luka Modric", "like", LocalDate.of(2024, 8, 5), "CL final! #football"),
                new UserAction(5L, "Luka Modric", "post", LocalDate.of(2024, 8, 6), "New boots line! #adidas"),
                new UserAction(7L, "Lionel Messi", "comment", LocalDate.of(2024, 8, 7), "Training hard for the next season #football"),
                new UserAction(2L, "Cristiano Ronaldo", "post", LocalDate.of(2024, 8, 8), "Back to the gym! #fitness"),
                new UserAction(2L, "Cristiano Ronaldo", "share", LocalDate.of(2024, 8, 9), "Book of the month recommendation #reading"),
                new UserAction(2L, "Cristiano Ronaldo", "like", LocalDate.of(2024, 8, 10), "E-commerce is booming #business"),
                new UserAction(5L, "Luka Modric", "comment", LocalDate.of(2024, 8, 11), "Ready for the playoffs #football"),
                new UserAction(1L, "Paul Pogba", "post", LocalDate.of(2024, 8, 12), "New tour dates announced! #music"),
                new UserAction(13L, "Mark Zuckerberg", "share", LocalDate.of(2024, 8, 13), "Metaverse update coming soon #technology"),
                new UserAction(14L, "Memphis Depay", "post", LocalDate.of(2024, 8, 14), "Launching new fashion line #fashion"),
                new UserAction(15L, "Sergio Ramos", "comment", LocalDate.of(2024, 8, 15), "What a game last night! #football"),
                new UserAction(15L, "Sergio Ramos", "post", LocalDate.of(2024, 8, 16), "New song out now! #music"),
                new UserAction(17L, "Kairat Nurtas", "share", LocalDate.of(2024, 8, 17), "Men sorpa iship algam #music #sorpa"),
                new UserAction(17L, "Kairat Nurtas", "like", LocalDate.of(2024, 8, 18), "Koymaimyz bey? #music"),
                new UserAction(17L, "Kairat Nurtas", "post", LocalDate.of(2024, 8, 19), "Almatynin tunderi-ai #music"),
                new UserAction(20L, "Pudge", "comment", LocalDate.of(2024, 8, 20), "Я как шаверма, не повезло будешь страдать #dota2")
        );

        SocialMediaAnalytics analytics = new SocialMediaAnalytics();

        List<String> top10ActiveUsers = analytics.findTop10ActiveUsers(actions);
        System.out.println("Top 10 Active Users: " + top10ActiveUsers);

        List<String> top5PopularTopics = analytics.findTop5PopularTopics(actions);
        System.out.println("Top 5 Popular Topics: " + top5PopularTopics);

        List<String> top3CommentersLastMonth = analytics.findTop3CommentersLastMonth(actions);
        System.out.println("Top 3 Commenters Last Month: " + top3CommentersLastMonth);

        System.out.println("Action Type Percentage: " + analytics.calculateActionTypePercentage(actions));
    }
}
