package school.faang.bjs2_87300;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> emailFunction,
                              Predicate<Email> emailPredicate) {
        for (Email email : emails) {
            if (emailPredicate.test(email)) {
                String originalBody = email.getBody();
                email.setBody(emailFunction.apply(email));
                emailConsumer.accept(email);
                email.setBody(originalBody);
            }
        }
    }
}
