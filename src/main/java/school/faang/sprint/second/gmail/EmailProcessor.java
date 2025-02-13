package school.faang.sprint.second.gmail;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails,
                              @NonNull Predicate<Email> predicate,
                              @NonNull Consumer<Email> consumer,
                              @NonNull Function<Email, String> function
    ) {
        emails.stream()
                .filter(predicate)
                .forEach(email -> {
                    Email emailWithUpdatedBody = new Email(
                            email.getSubject(),
                            function.apply(email),
                            email.isImportant()
                    );
                    consumer.accept(emailWithUpdatedBody);
                });
    }
}