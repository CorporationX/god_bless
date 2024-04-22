package faang.school.godbless.lambda.BJS2_5790;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> modification) {
        emails.forEach((Email email) -> {
            if (filter.test(email)) {
                try {
                    modification.apply(email);
                    process.accept(email);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        return emails;
    }
}
