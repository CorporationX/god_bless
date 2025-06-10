package school.faang.bjs2_80033;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> processor,
            Function<Email, String> transformer
    ) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                processor.accept(email);
                log.info("Обработано письмо: {}", email);
            }
        }
    }
}


