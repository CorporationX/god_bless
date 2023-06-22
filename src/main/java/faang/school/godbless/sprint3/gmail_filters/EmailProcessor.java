package faang.school.godbless.sprint3.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> condition,
            Function<Email, Email> function,
            Consumer<Email> action) {

        emails.stream()
                .filter(condition)
                .map(function)
                .forEach(action);
    }
}
