package faang.school.godbless.BJS2_6210;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> emailHandler, Function<Email, String> emailChanger) {
        for (Email email : emails) {
            if (emailFilter.test(email)) {
                email.setBody(emailChanger.apply(email));
            }
            if (email.getBody().toLowerCase().contains("spam")) {
                email.setSubject("!!!SPAM!!! " + email.getSubject());
            }
            emailHandler.accept(email);
        }
    }
}
