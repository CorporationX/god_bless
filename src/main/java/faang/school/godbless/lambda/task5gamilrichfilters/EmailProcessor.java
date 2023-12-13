package faang.school.godbless.lambda.task5gamilrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> transform) {
        System.out.println("------------------------------------");
        System.out.println("ВАЖНЫЕ ПИСЬМА:" );
        System.out.println("------------------------------------\n");
        for (Email email: emails) {
            if (filter.test(email)) {
                process.accept(email);
                System.out.println(transform.apply(email) + "\n");
            }
        }

        System.out.println("------------------------------------");
        System.out.println("НЕ СТОЯT ТВОЕГО ВНИМАНИЯ:");
        System.out.println("------------------------------------\n");

        for (Email email: emails) {
            if (!filter.test(email)) {
                process.accept(email);
                System.out.println(transform.apply(email) + "\n");
            }
        }
    }
}
