package faang.school.godbless.Task_15;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email: emails
             ) {
            System.out.println(filter.test(email));
            printEmail.accept(email);
            System.out.println(toUpperCase.apply(email));
        }
    }
}
