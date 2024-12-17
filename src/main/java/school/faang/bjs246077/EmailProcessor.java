package school.faang.bjs246077;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails, Predicate<Email> importantFilter,
                              Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        emails.stream()
                .filter(importantFilter)
                .peek(email -> email.setBody(toUpperCase.apply(email)))
                .forEach(printEmail);
    }
}
