package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processing, Function<Email, String> transformation) {
        for (Email email : emails) {
            filter.test(email);
            processing.accept(email);
            transformation.apply(email);
        }
    }
}