package school.faang.gmailfilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(Predicate<Email> filter, 
                              Function<Email, Email> corrector,
                              Consumer<Email> action,
                              List<Email> emails) {
        emails.stream()
                .filter(filter)
                .map(corrector)
                .forEach(action);

    }
}
