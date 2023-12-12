package faang.school.godbless.GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emails) {
            if (predicate.test(email)) {
                System.out.println("Это важное письмо: " + email.getSubject());
                consumer.accept(email);
                System.out.println(function.apply(email));
            } else
                System.out.println("Это не важное письмо: " + email.toString());
        }
    }
}
