package school.faang.bjs2_87300;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Consumer<Email> handler,
                              Function<Email, String> converter,
                              Predicate<Email> filter) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String originalBody = email.getBody();
                email.setBody(converter.apply(email));
                handler.accept(email);
                email.setBody(originalBody);
            }
        }
    }
}
