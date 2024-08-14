package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor, Function<Email, String> formatting) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedBody = formatting.apply(email);
                email.setBody(transformedBody);
                processor.accept(email);
            }
        }
    }
}
