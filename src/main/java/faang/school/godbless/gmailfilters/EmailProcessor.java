package faang.school.godbless.gmailfilters;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> predicate,
                               Consumer<Email> consumer, Function<Email, String> transformer) {
        Iterator<Email> iterator = emails.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (!predicate.test(email)) {
                iterator.remove();
            } else {
                String transformedBody = transformer.apply(email);
                email.setBody(transformedBody);
                consumer.accept(email);
            }
        }
    }
}
