package school.faang.bjs2_87315;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> importantFilter,
                             Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        emails.forEach((email -> {
            if (importantFilter.test(email)) {
                printEmail.accept(email);
                String edited = toUpperCase.apply(email);
                email.setBody(edited);
            }

        }));

    }
}
