package school.faang.bjs2_90750;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(
            List<Email> emails,
            Predicate<Email> importantFilter,
            Consumer<Email> printEmail,
            Function<Email, String> toUpperCase
    ) {
        List<Email> processed = new ArrayList<>();

        for (Email email : emails) {
            if (!importantFilter.test(email)) {
                System.out.printf("\"%s\" не прошло фильтрацию %n", email.getSubject());
            }
        }

        for (Email email : emails) {
            Email updated;
            if (importantFilter.test(email)) {
                updated = new Email(
                        email.getSubject(),
                        toUpperCase.apply(email),
                        email.isImportant()
                );
                printEmail.accept(updated);
            } else {
                updated = email;
            }
            processed.add(updated);
        }

        return processed;
    }
}