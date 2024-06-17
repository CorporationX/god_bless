package faang.school.godbless.module1.sprint2.task13;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UsersRandomGenerate {
    private static final List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah",
            "Ivy", "Jack", "Katherine", "Leo", "Mia", "Nina", "Oscar", "Paul",
            "Quincy", "Rachel", "Steve", "Tina", "Uma", "Victor", "Wendy",
            "Xander", "Yara", "Zane");
    private static final List<String> contents = Arrays.asList(
            "Hello world! #greeting",
            "Good morning! #morning #greeting",
            "How are you? #question",
            "Happy coding! #coding #fun",
            "Java is great! #java #coding",
            "Stream API is powerful! #java #coding",
            "Enjoy your day! #goodday",
            "Keep learning! #motivation",
            "Stay positive! #positivity",
            "Never give up! #motivation"
    );


    public static List<UsersActions> generateUserActions(int userCount) {
        Random random = new Random();

        List<UsersActions> userActions = new ArrayList<>();
        for (int i = 1; i <= userCount; i++) {
            String name = names.get(random.nextInt(names.size()));
            List<ActionType> actionTypes = new ArrayList<>();
            for (int j = 0; j < random.nextInt(100) + 1; j++) {

                for (int k = 0; k < random.nextInt(100) + 1; k++) {
                    ActionType actionType = ActionType.values()[random.nextInt(ActionType.values().length)];
                    actionTypes.add(actionType);
                }

                String content = contents.get(random.nextInt(contents.size()));
                LocalDateTime actionDate = LocalDateTime.now().minusDays(random.nextInt(60)); // Генерация случайной даты в пределах последних 60 дней
                userActions.add(new UsersActions(i, name, actionTypes, actionDate, content));
            }
        }
        return userActions;
    }

}
