package faang.school.godbless.bjs221477;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<String> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> modify) {
        return emails.stream()
                .filter(filter)
                .peek(process)
                .map(modify)
                .toList();
    }
}