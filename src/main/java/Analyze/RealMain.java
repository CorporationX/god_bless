package Analyze;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RealMain {
    public static void main(String args[]) {
        // Уважаемая Ира, если что-то не понятно - можешь возвращать задание и сказать чтобы я написал побольше комментариев, потому что код какой то слишком большой стал и мне кажется что тебе очень трудно(даже я иногда путаюсь)
        List<UserAction> userActions = Arrays.asList(
                new UserAction("1", "Alice", "post", LocalDate.now().minusDays(5), "Hello, world! #java"),
                new UserAction("2", "Richard", "comment", LocalDate.now().minusDays(4), "Great post!"),
                new UserAction("1", "Alice", "like", LocalDate.now().minusDays(3), ""),
                new UserAction("3", "Charlie", "post", LocalDate.now().minusDays(2), "I hate Stream API. #programming"),
                new UserAction("2", "Richard", "comment", LocalDate.now().minusDays(2), "I agree!"),
                new UserAction("1", "Alice", "share", LocalDate.now().minusDays(1), ""),
                new UserAction("3", "Charlie", "comment", LocalDate.now(), "Thanks for sharing!"),
                new UserAction("3", "Charlie", "comment", LocalDate.now().minusMonths(2), "AAAAAAAAAAAAAAAAA"), // не учитывается, потому что прошло 2 месяца
                new UserAction("4", "James", "comment", LocalDate.now().minusDays(2), "LOOL #FUUUN"),
                new UserAction("5", "Marie", "comment", LocalDate.now().minusDays(2), "I don't think so"),
                new UserAction("6", "Robert", "like", LocalDate.now().minusDays(2), "Haha it's funny"),
                new UserAction("7", "Erick", "comment", LocalDate.now().minusDays(2), "You are wrong."),
                new UserAction("8", "Liza", "post", LocalDate.now().minusDays(2), "Aaah look at this puppy! #animals"),
                new UserAction("9", "Gregory", "comment", LocalDate.now().minusDays(2), "Oh my goodness, this cat is amazing! #animals"),
                new UserAction("10", "Alexander", "share", LocalDate.now().minusDays(2), "I like Byzantine Empire. #GOD"), // не учитывается хэштег #GOD, потому что это share, a не comment или post
                new UserAction("11", "Christian", "comment", LocalDate.now().minusDays(2), "Ave Maria! #GOD"),
                new UserAction("4", "James", "share", LocalDate.now().minusDays(2), "No no no i have no money"),
                new UserAction("7", "Erick", "comment", LocalDate.now().minusDays(2), "Of course. "),
                new UserAction("8", "Liza", "post", LocalDate.now().minusDays(2), "Aaah look at this baby! #family"),
                new UserAction("9", "Gregory", "post", LocalDate.now().minusDays(2), "You are very smart! #intelligence"),
                new UserAction("6", "Robert", "like", LocalDate.now().minusDays(2), "")
        );

        Main analyzer = new Main();

        System.out.println("Top 10 Active Users: " + analyzer.findTop10ActiveUsers(userActions));
        System.out.println("Top 5 Popular Topics: " + analyzer.findTop5PopularTopics(userActions));
        System.out.println("Top 3 Commenting Users Last Month: " + analyzer.findTop3CommentingUsersLastMonth(userActions));
        System.out.println("Action Percentage: " + analyzer.calculateActionPercentage(userActions));
    }
}
