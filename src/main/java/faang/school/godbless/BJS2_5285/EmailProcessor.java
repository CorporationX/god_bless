package faang.school.godbless.BJS2_5285;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> emailPredicate,
            Consumer<Email> emailConsumer,
            Function<Email, String> emailFunction) {
        List<Email> filteredEmails = emails.stream().filter(emailPredicate).toList();
        for (Email email : filteredEmails) {
            System.out.println(emailFunction.apply(new Email(email.getSubject(), email.getBody(), email.getIsImportant())));
            emailConsumer.accept(email);
        }
    }
}
