package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> unprocessedEmails,
                              Predicate<Email> predicatedFilter,
                              Function<Email, String> processEmailBody,
                              Consumer<Email> processFinalEmail
    ) {
        unprocessedEmails.forEach(email -> {
            if (predicatedFilter.test(email)) {
                email.setBody(processEmailBody.apply(email));
                processFinalEmail.accept(email);
            }
        });
    }
}
