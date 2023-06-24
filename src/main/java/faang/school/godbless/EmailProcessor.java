package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            String upperCaseSubject = function.apply(email);
            email.setSubject(upperCaseSubject);

            if (predicate.test(email)) {
                consumer.accept(email);
            }
        }
    }
}
