package faang.school.godbless.javalambda.task5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailPredicate,
                              Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {

        emails.stream()
                .filter(emailPredicate)
                .peek(email -> email.setBody(emailFunction.apply(email)))
                .forEach(emailConsumer);
    }
}
