package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailPredicate, Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {
        for (Email email : emails) {
            emailPredicate.test(email);
            emailConsumer.accept(email);
            emailFunction.apply(email);
        }
    }
}
