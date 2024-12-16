package school.faang.task_45967;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> importantFilter,
                              Function<Email, String> toUpperCase,
                              Consumer<Email> printEmail
    ) {
        emails.stream()
                .filter(importantFilter)
                .peek(email -> email.setBody(toUpperCase.apply(email)))
                .forEach(printEmail);
    }
}