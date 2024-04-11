package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> treatment, Function<Email, String> transformation) {
        for (Email email : emails) {
            if (filter.test(email)) {
                treatment.accept(email);
                System.out.println("Содержание: " + transformation.apply(email));
            }
        }
    }
}
