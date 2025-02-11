package school.faang.sprint.second.gmail;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Consumer<Email> consumer,
                              Function<Email, String> function
    ) {
        emails.stream()
                .filter(predicate)
                .map(email -> new Email(email.getSubject(), function.apply(email), email.isImportant()))
                .forEach(consumer);
    }
}