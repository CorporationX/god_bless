package faang.school.godbless.BJS210258;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandomActionsList {
    public static final LocalDate START_DATE = LocalDate.of(2024, 5, 1);
    public static final LocalDate END_DATE = LocalDate.of(2024, 6, 14);

    public static String getRandomContent() {
        String[] contents = {
                "Posted a photo of a sunset",
                "Commented on a photo of a sunset",
                "Liked a photo of a sunset",
                "Reposted a photo of a sunset",
                "Posted a status update",
                "Commented on a status update",
                "Liked a status update",
                "Reposted a status update",
                "Posted a blog post about travel",
                "Commented on a blog post about travel",
                "Liked a blog post",
                "Reposted a blog post about travel",
                "Posted a photo of a cat",
                "Commented on a photo of a cat",
                "Liked a photo of a cat",
                "Reposted a photo of a cat",
                "Posted a recipe",
                "Commented on a recipe",
                "Liked a recipe",
                "Reposted a recipe",
                "Posted travel tips",
                "Commented on travel tips",
                "Liked travel tips",
                "Reposted travel tips",
                "Posted a book review",
                "Commented on a book review",
                "Liked a book review",
                "Reposted a book review",
                "Posted a movie review",
                "Commented on a movie review",
                "Liked a movie review",
                "Reposted a movie review",
                "Posted workout tips",
                "Commented on workout tips",
                "Liked workout tips",
                "Reposted workout tips"
        };

        String content = contents[new Random().nextInt(contents.length)];
        return new Random().nextBoolean() ? content + " #" + content.split(" ")[2] : content;
    }

    public static LocalDate getRandomDate() {
        LocalDate startDate = START_DATE;
        LocalDate endDate = END_DATE;
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return startDate.plusDays(new Random().nextInt((int) daysBetween + 1));
    }

    public static List<UserAction> generateUserActions(int numberOfActions) {
        List<UserAction> userActions = new ArrayList<>();
        String[] userNames = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack", "Karen", "Leo", "Mia", "Nina", "Oscar"};
        List<String> userNamesList = List.of(userNames);
        Actions[] actionTypes = Actions.values();

        for (int i = 1; i <= numberOfActions; i++) {
            String name = userNames[new Random().nextInt(userNames.length)];
            Actions actionType = actionTypes[new Random().nextInt(actionTypes.length)];
            LocalDate actionDate = getRandomDate();
            String content = getRandomContent();
            userActions.add(new UserAction(userNamesList.indexOf(name), name, actionType, actionDate, content));
        }

        return userActions;
    }
}
