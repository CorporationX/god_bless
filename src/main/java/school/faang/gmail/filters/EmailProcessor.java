package school.faang.gmail.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> emailPrinter, Function<Email, String> emailFormatter) {
        for (Email email : emails) {
            if (emailFilter.test(email)) {
                emailPrinter.accept(email);
                email.setBody(emailFormatter.apply(email));
            }
        }
    }
}
