package school.faang.sprint2.task45952gmailrich;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler,
                              Function<Email, String> bodyConversion) {
        List<Email> processedEmails = new ArrayList<>();
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(bodyConversion.apply(email));
                processedEmails.add(email);
                handler.accept(email);
            }
        }
        emails.clear();
        emails.addAll(processedEmails);
    }
}
