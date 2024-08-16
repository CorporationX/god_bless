package faang.school.godbless.secondsprint.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor,
                              Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                processor.accept(email);
                String transformedBody = transformer.apply(email);
                System.out.println("Обработанное тело письма: " + transformedBody);
            }
        }
    }
}
