package school.faang.gmail.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private static final Logger logger = LoggerFactory.getLogger(EmailProcessor.class);

    public void processEmails(List<Email> letters, Predicate<Email> filter,
                              Consumer<Email> handler, Function<Email, String> converter) {
        checkValidArgument(letters, "letters");
        checkValidArgument(filter, "filter");
        checkValidArgument(handler, "handler");
        checkValidArgument(converter, "converter");
        for (Email letter : letters) {
            if (filter.test(letter)) {
                letter.setBody(converter.apply(letter));
                handler.accept(letter);
            }
        }
    }

    private <T> void checkValidArgument (T argument, String argumentName) {
        if (argument == null) {
            logger.error("The argument {} cannot be null! Location {} : {}",
                    argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The argument " + argumentName + " cannot be null!");
        }
        if (argument.getClass() == String.class && ((String) argument).isBlank()) {
            logger.error("The argument {} cannot be blank! Location {} : {}",
                    argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The argument " + argumentName + " cannot be blank!");
        }
    }
}
