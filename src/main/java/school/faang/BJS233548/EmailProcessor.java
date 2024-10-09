package school.faang.BJS233548;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> mailFilter, Consumer<Email> mailProcessor, Function<Email, String> mailFunction) {
        emails.stream().filter(mailFilter).forEach(e -> {
            mailProcessor.accept(e);
            e.setBody(mailFunction.apply(e));
        });
    }
}
