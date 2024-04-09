package faang.school.godbless.gmailRichFilter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> function) {
        for (Email email : emails) {
            action.accept(email);
            if (filter.test(email)) {
                System.out.println(email.getSubject() + " is important.");
            }
            System.out.println(function.apply(email));
            System.out.println();
        }
    }
}
