package faang.school.godbless.sprint2.BJS2_5386;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> processedEmails = new ArrayList<>();

        emails.forEach((Email email) -> {
            if (predicate.test(email)) {
                processedEmails.add(new Email(email.getSubject(), function.apply(email), email.isImportant()));
                consumer.accept(email);
            }
        });

        return processedEmails;
    }
}
