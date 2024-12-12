package school.faang.bjs_45873;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> converter,
                              Consumer<Email> processor) {
        if (emails == null || filter == null || converter == null || processor == null) {
            throw new IllegalArgumentException("The method parameters must be not null!");
        }

        List<Email> convertedEmails = emails.stream()
                .filter(filter)
                .toList();

        convertedEmails.forEach(email -> {
            email.setBody(converter.apply(email));
            processor.accept(email);
        });

        return convertedEmails;
    }
}