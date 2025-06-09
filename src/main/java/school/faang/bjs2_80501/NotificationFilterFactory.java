package school.faang.bjs2_80501;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;

public class NotificationFilterFactory {
    private static final Set<String> FORBIDDEN_WORDS = Set.of(
            "way", "какая-то нецензурная лексика", "dog"
    );
    private static final String SPLIT_REGEX = "[;,.:\\s-]";
    public static final int DEFAULT_MIN_LENGTH = 5;

    public Predicate<String> filterForbiddenWords() {
        return message -> {
            String[] messageSplit = message.split(SPLIT_REGEX);
            return Arrays.stream(messageSplit).noneMatch(FORBIDDEN_WORDS::contains);
        };
    }

    public Predicate<String> filterMessageLength(int minLength) {
        return message -> {
            String[] messageSplit = message.split(SPLIT_REGEX);
            return messageSplit.length > minLength;
        };
    }

}
