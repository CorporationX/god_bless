package gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Consumer<Email> processor,
                                     Function<Email, ?> convertor) {
        emails.stream()
                .filter(filter)
                .forEach(mail -> {
                    processor.accept(mail);
                    System.out.println(convertor.apply(mail));
                });
    }
}
