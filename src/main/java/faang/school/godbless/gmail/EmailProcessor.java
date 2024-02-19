package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            boolean isImportant = filter.test( email );
            if (isImportant) {
                function.apply( email );
                consumer.accept( email );
            }
        }
    }
}
