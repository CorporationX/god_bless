package school.faang.gmail.filters;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter,
                              Function<Email, String> emailModifier, Consumer<Email> emailHandler) {
        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("Не возможно применить фильтры, если нет писем");
        }
        if (emailFilter == null) {
            throw new IllegalArgumentException("emailFilter не может быть null");
        }
        if (emailHandler == null) {
            throw new IllegalArgumentException("emailHandler не может быть null");
        }
        if (emailModifier == null) {
            throw new IllegalArgumentException("emailModifier не может быть null");
        }
        Iterator<Email> iterator = emails.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (!emailFilter.test(email)) {
                iterator.remove();
            }
            email.setBody(emailModifier.apply(email));
            emailHandler.accept(email);
        }
    }
}
