package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static List<Email> processEmails(List<Email> listInputEmails, Predicate<Email> filterCondition,
                                            Function<Email, String> transform, Consumer<Email> processing) {

        var listOut = listInputEmails.stream().filter(filterCondition).toList();
        listOut.forEach(e -> e.setBody(transform.apply(e)));
        listOut.forEach(processing);
        return listOut;
    }
}
