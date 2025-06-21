package school.faang.bjs2_80080;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> action,
            Function<Email, String> transformer
    ) {
        for (int i = 0; i < emails.size(); i++) {
            Email email = emails.get(i);
            if (filter.test(email)) {
                email.setBody(transformer.apply(email));
                emails.set(i, email);
                action.accept(email);
                continue;
            }
            emails.remove(i);
            i--;
        }
    }
}
