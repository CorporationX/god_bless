package faang.school.godbless.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> emailHandler, Function<Email, String> emailTransform) {
        emails.forEach(email -> {
            emailFilter.test(email);
            emailHandler.accept(email);
            emailTransform.apply(email);
        });
    }
}