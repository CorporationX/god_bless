package dima.evseenko.gmail;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, Email> function) {
        if (Objects.nonNull(emails)) {
            Stream<Email> stream = emails.stream();

            if (Objects.nonNull(consumer)) {
                stream = stream.peek(consumer);
            }

            if (Objects.nonNull(predicate)) {
                stream = stream.filter(predicate);
            }

            if (Objects.nonNull(function)) {
                stream = stream.map(function);
            }

            return stream.toList();
        }
        return emails;
    }
}
