package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Consumer<Email> process,
                                     Function<Email, Email> modify) {
        List<Email> processedEmails = new ArrayList<>();
        for (Email email : emails) {
            if (filter.test(email)) {
                processedEmails.add(modify.apply(email));
                process.accept(email);
            }
        }
        return processedEmails;
    }
}
