package school.faang.gmailrichfilters45992;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformerBody = transformer.apply(email);
                email.setBody(transformerBody);
                handler.accept(email);
            }
        }
    }
}
