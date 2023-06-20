package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> mapper) {
        validateFunction(filter, "Filter");
        validateFunction(consumer, "Consumer");
        validateFunction(mapper, "Mapper");

        for (Email email : emails) {

            if (filter.test(email)) {
                consumer.accept(email);
                mapper.apply(email);
            }
        }
    }

    private <T> void validateFunction(T function, String functionName) {
        if (function == null) {
            throw new IllegalArgumentException(functionName + " function can't ber null");
        }
    }
}
