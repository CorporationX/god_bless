package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static List<Email> processEmails(List<Email> emails, Predicate<Email> emailPredicate, Consumer<Email> emailConsumer, Function<Email, Email> emailFunction) {
        return emails.stream()
                .filter(emailPredicate)
                .peek(emailConsumer)
                .map(emailFunction).toList();
    }
}