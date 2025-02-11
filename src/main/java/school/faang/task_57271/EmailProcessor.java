package school.faang.task_57271;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter,
                              Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email : emails) {
            if (importantFilter.test(email)) {
                String newBody = toUpperCase.apply(email);
                email.setBody(newBody);
                printEmail.accept(email);
            }
            toUpperCase.apply(email);
        }
    }
}
