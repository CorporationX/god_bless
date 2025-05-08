package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> inputEmails, Predicate<Email> emailFilter,
                              Function<Email, String> emailBody, Consumer<Email> emailConsumer) {
        inputEmails.forEach(email -> {
            if (emailFilter.test(email)) {
                email.setBody(emailBody.apply(email));
                emailConsumer.accept(email);
            }
        });

    }

}
