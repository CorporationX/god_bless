package school.faang.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> unprocessedEmails,
                              Predicate<Email> predicatedFilter,
                              Consumer<Email> doSomeThing,
                              Function<Email, String> process) {
        unprocessedEmails.forEach(email -> {
            if (predicatedFilter.test(email)) {
                email.setBody(process.apply(email));
                doSomeThing.accept(email);
            }
        });
    }
}
