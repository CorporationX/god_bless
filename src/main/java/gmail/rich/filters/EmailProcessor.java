package gmail.rich.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Consumer<Email> emailHandler,
                              Function<Email, String> emailEditor) {
        emails.stream()
                .filter(emailFilter)
                .peek(emailHandler)
                .map(emailEditor)
                .forEach(System.out::println);
    }
}
