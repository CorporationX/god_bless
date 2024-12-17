package school.faang.task_47168;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class UserActionGenerator {

    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "Dave"};
    private static final String[] CONTENTS = {
            "Check out this amazing #newfeature!",
            "I totally agree with #newfeature.",
            "#conference", "#bootcamp has a lot of features", "#Java is awesome!"
    };
    private static final Random RANDOM = new Random();

    public static List<UserAction> generateRandomActions(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new UserAction(
                        RANDOM.nextInt(100),
                        NAMES[RANDOM.nextInt(NAMES.length)],
                        ActionType.values()[RANDOM.nextInt(ActionType.values().length)],
                        LocalDate.now().minusDays(RANDOM.nextInt(100)),
                        CONTENTS[RANDOM.nextInt(CONTENTS.length)]
                ))
                .toList();
    }
}