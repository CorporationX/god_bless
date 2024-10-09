package faang.school.godbless.lambda.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> modification, Consumer<Email> process) {

        for(var email : emails) {
            if (filter.test(email)) {
                var newBody = modification.apply(email);
                email.setBody(newBody);
                process.accept(email);
            }
        }
    }
}
