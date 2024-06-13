package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> process,
                              Function<Email, String> modify) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setSubject(modify.apply(email));
                process.accept(email);
            }
        }
    }
}
