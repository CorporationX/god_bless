package school.faang.gmailrichfilters;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> emails, @NonNull Predicate<Email> filter,
                              @NonNull Consumer<Email> consumerEmail,
                              Function<Email, String> changeBody) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = changeBody.apply(email);
                Email newMail = new Email(email.getSubject(), newBody, email.isImportant());
                consumerEmail.accept(newMail);
            }
        }
    }
}
