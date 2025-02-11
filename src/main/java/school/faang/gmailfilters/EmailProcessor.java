package school.faang.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> function, Consumer<Email> handler) {
        checkArguments(emails, filter);
        checkArguments(function, handler);
        for (Email email : emails) {
            if (filter.test(email)) {
                handler.accept(email);
                email.setBody(function.apply(email));
            }
        }
    }

    public void checkArguments(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new IllegalArgumentException("Ошибка, переменная равна null");
        }
    }
}