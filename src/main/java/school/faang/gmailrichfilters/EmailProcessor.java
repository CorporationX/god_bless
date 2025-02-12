package school.faang.gmailrichfilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> consumerEmail,
                              Function<Email, String> changeBody) {
        Objects.requireNonNull(emails);
        Objects.requireNonNull(filter);
        Objects.requireNonNull(consumerEmail);
        for (Email email : emails) {
            if (filter.test(email)) {
                String newBody = changeBody.apply(email);
                Email newMail = new Email(email.getSubject(), newBody, email.isImportant());
                emails.set(emails.indexOf(email), newMail);
                consumerEmail.accept(newMail);
            }
        }
    }
}
