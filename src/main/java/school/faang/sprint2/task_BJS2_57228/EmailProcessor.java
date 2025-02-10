package school.faang.sprint2.task_BJS2_57228;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, Email> convert, Consumer<Email> process) {
        emails.stream().filter(filter).map(convert).forEach(process);
    }
}
