package school.faang.bjs2_90895;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                             Predicate<Email> filter,
                             Function<Email, String> transformer,
                             Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedText = transformer.apply(email);
                email.setBody(transformedText);
                action.accept(email);
            }
        }
    }
}

// Вариант без изменений(Function<Email, Email>):
// Email transformedEmail = transformer.apply(email);
//                action.accept(transformedEmail);