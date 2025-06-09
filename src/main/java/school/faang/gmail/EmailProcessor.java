package school.faang.gmail;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> processor, Consumer<Email> consumer) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(processor.apply(email));
                consumer.accept(email);
            }
        }
    }
}
