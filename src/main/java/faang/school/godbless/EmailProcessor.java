package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer,
                              Function<Email, String> mapper){
        validateFunction(filter);
        validateFunction(consumer);
        validateFunction(mapper);

        for (Email email: emails){
            filter.test(email);
            consumer.accept(email);
            mapper.apply(email);
        }
    }

    private <T> void validateFunction(T function){
        if (function==null){
            throw new IllegalArgumentException("Function cannot be null!");
        }
    }
}
