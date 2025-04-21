package school.faang.bjs2_70544;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> importance,
                              Consumer<Email> subject,
                              Function<Email, String> bodyModifier) {
        emails.stream().filter(importance).forEach(email -> {
            email.setBody(bodyModifier.apply(email));
            subject.accept(email);
        });
    }
}
