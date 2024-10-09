package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<String> processEmails(List<Email> allEmails, Predicate<Email> predicate,
                              Function<Email, String> function, Consumer<Email> consumer) {
        List<String> allBody = allEmails.stream()
                .filter(predicate)
                .map(function)
                .toList();
        allEmails.forEach(consumer);
        return allBody;
    }

}
