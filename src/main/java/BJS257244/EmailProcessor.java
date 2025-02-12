package BJS257244;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email> printEmail,
                              Function<Email, String> toUpperCase) {
        log.info("Processing emails");
        emails.forEach(email -> {
            importantFilter.test(email);
            if (importantFilter.test(email)) {
                toUpperCase.apply(email);
                printEmail.accept(email);
            }
        });
    }
}
