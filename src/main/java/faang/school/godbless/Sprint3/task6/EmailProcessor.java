package faang.school.godbless.Sprint3.task6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        int i = 0;
        for (Email email : emails) {
            if (predicate.test(email)) {
                consumer.accept(email);
                System.out.println(function.apply(email));
            } else {
                i += 1;
            }
        }
        System.out.println(i + " emails went to spam");
    }
}