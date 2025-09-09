package school.faang.module2.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Consumer<Email> consumer,
                                     Function<Email, Email> function) {

        return emails.stream()
                .filter(filter)
                .peek(consumer)
                .map(function)
                .toList();
    }

}
