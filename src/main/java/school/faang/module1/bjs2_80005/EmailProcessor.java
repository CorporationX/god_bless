package school.faang.module1.bjs2_80005;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> bodyTransformer,
                              Consumer<Email> handler) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(bodyTransformer.apply(email));
                handler.accept(email);
            }
        }
    }
}