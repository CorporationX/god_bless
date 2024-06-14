package faang.school.godbless.GmailRichFilters;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emails.stream()
                .peek(email -> {
                    if (predicate.test(email)) {
                        email.setBody(function.apply(email));
                        consumer.accept(email);

                    }
                })
                .toList();
    }
}
