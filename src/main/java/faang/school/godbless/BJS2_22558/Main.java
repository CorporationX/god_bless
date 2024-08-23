package faang.school.godbless.BJS2_22558;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = List.of(
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content #OG2024", getRandomDate()),
                new UserAction(1, "Denis", ActionTypes.LIKE, "Content #java",  getRandomDate()),
                new UserAction(1, "Denis", ActionTypes.SHARE, "Content", getRandomDate()),
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content", getRandomDate()),
                new UserAction(1, "Denis", ActionTypes.COMMENT, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content #kotlin", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.SHARE, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.POST, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.COMMENT, "Content", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.LIKE, "Content #go", getRandomDate()),
                new UserAction(2, "Max", ActionTypes.LIKE, "Content #sumerki", getRandomDate()),
                new UserAction(3, "Gosh", ActionTypes.LIKE, "Content #java", getRandomDate()),
                new UserAction(3, "Gosh", ActionTypes.LIKE, "Content", getRandomDate()),
                new UserAction(4, "Anton", ActionTypes.COMMENT, "Content #sumerki", getRandomDate()),
                new UserAction(5, "Maria", ActionTypes.SHARE, "Content", getRandomDate()),
                new UserAction(5, "Maria", ActionTypes.SHARE, "Content #kotlin", getRandomDate()),
                new UserAction(7, "Katia", ActionTypes.COMMENT, "Content #sumerki", getRandomDate()),
                new UserAction(7, "Katia", ActionTypes.POST, "Content", getRandomDate()),
                new UserAction(8, "Katia", ActionTypes.POST, "Content #java", getRandomDate()),
                new UserAction(9, "Katia", ActionTypes.POST, "Content", getRandomDate()),
                new UserAction(10, "Katia", ActionTypes.COMMENT, "Content #bestseller", getRandomDate()),
                new UserAction(11, "Katia", ActionTypes.POST, "Content #java", getRandomDate())
        );

        System.out.println(UserAction.getTop10MostActiveUsers(actions));
        System.out.println(UserAction.findTop5PopularThemes(actions));
        System.out.println(UserAction.findTop3UserByComments(actions));
        System.out.println(UserAction.getActionsByPercentage(actions));

    }
    private static LocalDate getRandomDate() {
        LocalDate startDate = LocalDate.of(2024, 6, 1);
        long randomDays = new Random().nextInt(91);
        return startDate.plusDays(randomDays);
    }

}
