package school.faang.gmailrichfilters.maincode;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emails, Predicate<Email> filter,
                             Consumer<Email> consumer, Function<Email, String> transformer) {
        for (Email email :emails) {
            if(filter.test(email)) {
                String transformerBody = transformer.apply(email);
                email.setBody(transformerBody);
                System.out.println(transformerBody);

                consumer.accept(email);
            }
        }
    }
}