package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public static List<Email> processEmails(List<Email> listInputEmails, Predicate<Email> filterCondition,
                                            Function<Email, String> transformer, Consumer<Email> processor) {

        Objects.requireNonNull(listInputEmails, "List of emails shouldn't be null");
        Objects.requireNonNull(filterCondition, "The email handler shouldn't be null");
        Objects.requireNonNull(transformer, "The email transformer shouldn't null");
        Objects.requireNonNull(processor, "The email processor shouldn't be null");

        List<Email> listOut = listInputEmails.stream().filter(filterCondition).toList();
        listOut.forEach(email -> email.setBody(transformer.apply(email)));
        listOut.forEach(processor);
        return listOut;
    }
}
