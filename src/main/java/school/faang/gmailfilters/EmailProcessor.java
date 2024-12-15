package school.faang.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> transformer) {
        emails.replaceAll(email -> {
            if (filter.test(email)) {
                String transformedBody = transformer.apply(email);
                Email transformedEmail = new Email(email.getSubject(), transformedBody, email.isImportant());
                handler.accept(transformedEmail);
                return transformedEmail;
            } else {
                return email;
            }
        });
    }
}