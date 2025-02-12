package school.faang.sprint2.lambda.gmailfilters;

import java.util.ArrayList;
import java.util.Iterator;
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
                System.out.println(transformer.apply(email));
            }
        }
    }
}
