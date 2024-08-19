package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private static final Predicate<Email> ALWAYS_TRUE = e -> true;
    private static final Consumer<Email> NO_OPERATION = e -> {};
    private static final Function<Email, String> GET_BODY = Email::getBody;

    public List<String> processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> transformer) {

        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Email list can't be null/empty!.");
        }

        return emails.stream()
                .filter(filter != null ? filter : ALWAYS_TRUE)
                .peek(processor != null ? processor : NO_OPERATION)
                .map(transformer != null ? transformer : GET_BODY)
                .toList();
    }
}
