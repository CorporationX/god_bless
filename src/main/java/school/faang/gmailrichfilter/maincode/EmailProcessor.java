package school.faang.gmailrichfilter.maincode;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> filter,
                             Function<Email, String> transformer, Consumer<Email> consumer) {
        for (Email email :emails) {
            if(filter.test(email)) {
                String transformerBody = transformer.apply(email);
                System.out.println(transformerBody);

                consumer.accept(email);
            }
        }
    }
}
