package GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProccesor {

    public void processEmails(List<Email> emails, Predicate<Email> emailFilter,
                              Consumer<Email> emailConsumer, Function<Email, String> emailTransform) {
        for (Email email : emails) {
            if (emailFilter.test(email)) {
                System.out.println(emailTransform.apply(
                        new Email(email.getSubject(), email.getBody(), email.isImportant())));
                emailConsumer.accept(email);
            }
        }
    }
}
