package task5lymbda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformerBody = transformer.apply(email);
                email = new Email(email.getSubject(), transformerBody, email.isImportant());
                process.accept(email);
            }
        }
    }
}
