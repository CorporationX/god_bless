package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> bodyEdit,
                              Consumer<Email> emailConsumer) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    Email processedEmail = new Email(
                            email.getSubject(),
                            bodyEdit.apply(email),
                            email.isImportant()
                    );
                    emailConsumer.accept(processedEmail);
                });
    }
}
