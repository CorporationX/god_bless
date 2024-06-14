package faang.school.godbless.BJS29403;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processing,
                                     Function<Email, Email> transforming) {
        return emails.stream().filter(filter).peek(processing).
                map(transforming).toList();
    }
}
