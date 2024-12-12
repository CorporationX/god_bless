package school.faang.bjs246090;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Function<Email, String> function,
                              Consumer<Email> consumer) {
        if (emails == null || predicate == null || consumer == null || function == null) {
            return;
        }
        emails.stream().filter(predicate).peek(email -> email.setBody(function.apply(email))).forEach(consumer);
    }
}
