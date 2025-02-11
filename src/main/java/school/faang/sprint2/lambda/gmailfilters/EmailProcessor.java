package school.faang.sprint2.lambda.gmailfilters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> transformer) {
        List<String> headersList = new ArrayList<>();
        Iterator<Email> iterator = emails.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (!filter.test(email)) {
                iterator.remove();
            }
            transformer.apply(email);
            handler.accept(email);
        }
    }
}
