package faang.school.godbless.BJS2_21382;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> formatting) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String formattedBody = formatting.apply(email);
                email.setBody(formattedBody);
                emailConsumer.accept(email);
            }
        }
    }
}
