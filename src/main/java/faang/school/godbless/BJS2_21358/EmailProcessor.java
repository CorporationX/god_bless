package faang.school.godbless.BJS2_21358;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> emailHandler,
                              Function<Email, String> emailConversion) {
        for (Email email : emails) {
            if (filter.test(email)) {
                emailHandler.accept(email);
                System.out.println(emailConversion.apply(email));
            }
        }
    }
}
