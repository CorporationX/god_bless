package school.faang.Gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> transformer){
        emails.stream().filter(filter).peek(e -> e.setBody(transformer.apply(e))).forEach(action);
    }
}
