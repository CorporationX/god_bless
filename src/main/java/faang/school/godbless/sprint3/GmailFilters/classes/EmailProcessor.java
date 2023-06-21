package faang.school.godbless.sprint3.GmailFilters.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<Email> processEmail(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
                result.add(email);
            }
        }
        return result;
    }
}
