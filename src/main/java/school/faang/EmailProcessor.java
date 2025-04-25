package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {

    public void processEmails(
            List<Email> mails,
            Predicate<Email> checkImportance,
            Function<Email, String> upper,
            Consumer<Email> printer
    ) {
        for (Email email : mails) {
            if (checkImportance.test(email)) {
                String updatedBody = upper.apply(email);
                email.setBody(updatedBody);
                printer.accept(email);
                log.info("Письмо обработано: {}", email.getSubject());
            }
        }
    }
}
