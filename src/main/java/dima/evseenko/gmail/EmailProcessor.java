package dima.evseenko.gmail;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        if (Objects.nonNull(emails)) {
            List<Email> emailsCopy = List.copyOf(emails);
            emailsCopy.forEach(email -> {
                if (Objects.nonNull(printEmail)) {
                    printEmail.accept(email);
                }

                if (Objects.nonNull(importantFilter) && !importantFilter.test(email)) {
                    emails.remove(email);
                }

                if (Objects.nonNull(toUpperCase)) {
                    email.setBody(toUpperCase.apply(email));
                }
            });
        }
    }
}
