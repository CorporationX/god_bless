package school.faang.Lambda.BJS2_33574;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList,
                              Predicate<Email> filter,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> bodyTransformer) {
        for (Email email : emailList) {
            if (filter.test(email)) {
                String transformedBody = bodyTransformer.apply(email);
                email.setBody(transformedBody);

                emailConsumer.accept(email);
            }
        }
    }
}
