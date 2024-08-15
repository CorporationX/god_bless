package faang.school.godbless.BJS2_21375;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processing,
                              Function<Email, String> conversions) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(conversions.apply(email));
                processing.accept(email);
            }
        }
    }
}
