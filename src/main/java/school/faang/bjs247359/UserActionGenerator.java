package school.faang.bjs247359;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class UserActionGenerator {
    private static final String[] NAMES =
            {"Sergey", "Aleksandr", "Anna", "Nikolay", "Andrey", "Veronika", "Konstantin", "Olga", "Pavel", "Igor"};
    private static final String[] ACTION_TYPE = {"post", "comment", "like", "share"};
    private static final String[] CONTENTS = {"Check out this cool #project",
            "Thanks for sharing #project!", "Loving the new #feature release!", "#Java is indeed awesome.",
            "Introducing a new #update to the system.", "#update looks great!"};
    private static final Random RANDOM = new Random();

    public static List<UserAction> generateRandomActions(int count) {
        return IntStream.range(0, count)
                .mapToObj(current -> new UserAction(NAMES[RANDOM.nextInt(NAMES.length)],
                        ACTION_TYPE[RANDOM.nextInt(ACTION_TYPE.length)],
                        LocalDate.now().minusDays(RANDOM.nextInt(100)),
                        CONTENTS[RANDOM.nextInt(CONTENTS.length)]))
                .toList();
    }
}
