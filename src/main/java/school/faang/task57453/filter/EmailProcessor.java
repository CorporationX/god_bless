package school.faang.task57453.filter;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(@NonNull List<Email> emails, @NonNull Predicate<Email> importantFilter,
                              @NonNull Consumer<Email> printEmail, @NonNull Function<Email, String> toUpperCase) {
        for (Email email : emails) {
            if (importantFilter.test(email)) {
                email.setBody(toUpperCase.apply(email));
                printEmail.accept(email);
            }
        }
    }
}
