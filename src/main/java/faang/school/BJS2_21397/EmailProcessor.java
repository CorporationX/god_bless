package faang.school.BJS2_21397;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> transformation) {
        emails.stream()
                .filter(filter)
                .peek(process)
                .map(transformation)
                .toList();
    }
}
