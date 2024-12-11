package school.faang.task_45887;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    void processEmails(List<Email> emails,
                       Predicate<Email> filter,
                       Function<Email, String> converter,
                       Consumer<Email> handler) {
        validateInputParameters(emails, filter, converter, handler);

        for (Email email : emails) {
            if (filter.test(email)) {
                var convertedBody = converter.apply(email);
                email.setBody(convertedBody);
                handler.accept(email);
            }
        }
    }

    private static void validateInputParameters(List<Email> emails, Predicate<Email> filter, Function<Email, String> converter, Consumer<Email> handler) {
        if (emails == null || filter == null || converter == null || handler == null) {
            throw new IllegalArgumentException("Некорректные входные параметры!");
        }
    }
}
