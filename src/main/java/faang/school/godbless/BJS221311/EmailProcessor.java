package faang.school.godbless.BJS221311;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filtering,
                              Consumer<Email> processing,
                              Function<Email, String> conversions) {
        for (Email email : emails) {
            if (filtering.test(email)) {
                email.setBody(conversions.apply(email));
                processing.accept(email);
            }
        }
    }
}
