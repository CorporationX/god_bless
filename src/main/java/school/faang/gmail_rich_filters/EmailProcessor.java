package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filterer, Function<Email,
            String> converter, Consumer<Email> processor) {
        emails.removeIf(filterer);
        for (Email email : emails) {
            processor.accept(email);
            System.out.println(converter.apply(email));
        }
    }
}
