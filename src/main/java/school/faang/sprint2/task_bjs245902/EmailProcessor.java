package school.faang.sprint2.task_bjs245902;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> printEmail,
                              Function<Email, String> toUpperCase) {

        for (Email email : emails) {
            if (filter.test(email)) {
                String convertedEmailBody = toUpperCase.apply(email);
                email.setBody(convertedEmailBody);
                printEmail.accept(email);
            }
        }
    }

}
