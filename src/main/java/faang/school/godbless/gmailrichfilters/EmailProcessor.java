package faang.school.godbless.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<String> processEmails(List<Email> emails,
                                      Predicate<Email> filter,
                                      Consumer<Email> consumer,
                                      Function<Email, String> function) {
        return emails.stream()
                .filter(filter)
                .peek(consumer)
                .map(function)
                .toList();
    }
}
