package faang.school.godbless.module.second.lambda.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
        List<Email> emails,
        Predicate<Email> filter,
        Function<Email,String> converter,
        Consumer<String> process
    ) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                process.accept(converter.apply(email));
            }
        });
    }
}
