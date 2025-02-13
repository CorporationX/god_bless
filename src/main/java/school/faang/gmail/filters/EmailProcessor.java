package school.faang.gmail.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private static final Logger logger = LoggerFactory.getLogger(EmailProcessor.class);
    private static final String ERROR_NULL = "The argument cannot be null!";

    public void processEmails(List<Email> letters, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> converter) {
        try {
            Objects.requireNonNull(letters, ERROR_NULL);
            Objects.requireNonNull(filter, ERROR_NULL);
            Objects.requireNonNull(handler, ERROR_NULL);
            Objects.requireNonNull(converter, ERROR_NULL);
        } catch (Exception e) {
            logger.error(ERROR_NULL, e.getMessage(), e);
        }
        for (Email letter : letters) {
            if (filter.test(letter)) {
                letter.setBody(converter.apply(letter));
                handler.accept(letter);
            }
        }
    }

    public void printEmail(Email letter) {
        Objects.requireNonNull(letter, ERROR_NULL);
        logger.info("Обработано письмо: {}", letter.getSubject());
    }

}
