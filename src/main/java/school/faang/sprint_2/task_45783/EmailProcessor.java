package school.faang.sprint_2.task_45783;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(
            List<Email> emails,
            Predicate<Email> filterEmail,
            Function<Email, String> transformEmail,
            Consumer<Email> handleEmail
    ) {
        return emails.stream()
                .filter(filterEmail)
                .peek(email -> email.setBody(transformEmail.apply(email)))
                .peek(handleEmail::accept)
                .toList();
    }
}
