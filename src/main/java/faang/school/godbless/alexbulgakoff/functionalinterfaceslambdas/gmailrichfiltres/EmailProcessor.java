package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.gmailrichfiltres;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Alexander Bulgakov
 */

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> emailPredicate,
                              Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {

        emails.stream().filter(emailPredicate).forEach(email -> {
            emailFunction.apply(new Email(email.getSubject(), email.getBody(), email.isImportant()));
            emailConsumer.accept(email);
        });
    }
}
