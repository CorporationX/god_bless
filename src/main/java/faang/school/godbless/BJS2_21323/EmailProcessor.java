package faang.school.godbless.BJS2_21323;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> listEmails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : listEmails) {
            if (predicate.test(email)) {
                consumer.accept(email);
                System.out.println( function.apply(email));
            }
        }
    }
}
