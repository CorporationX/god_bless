package school.faang.task_47168;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserActionGenerator {
    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "Dave"};
    private static final String[] CONTENTS = {
            "Check out this amazing #newfeature!",
            "I totally agree with #newfeature.",
            "This is #conference news.",
            "Check out this cool #project.",
            "#Java is awesome!"
    };
    private static final UserAction.ActionType[] ACTION_TYPES = UserAction.ActionType.values();
    private static final Random RANDOM = new Random();

    public static List<UserAction> generateRandomActions(int count) {
        List<UserAction> actions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            actions.add(new UserAction(
                    RANDOM.nextInt(10) + 1,
                    NAMES[RANDOM.nextInt(NAMES.length)],
                    ACTION_TYPES[RANDOM.nextInt(ACTION_TYPES.length)],
                    LocalDate.now().minusDays(RANDOM.nextInt(60)),
                    CONTENTS[RANDOM.nextInt(CONTENTS.length)]
            ));
        }
        return actions;
    }
}