package school.faang.task2104;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor, Function<Email, String> transformer) {
        List<Email> filteredEmails = emails.stream()
                .filter(filter)
                .collect(Collectors.toList());

        for (Email email : filteredEmails) {
            email.setBody(transformer.apply(email));
            processor.accept(email);
        }
    }
}