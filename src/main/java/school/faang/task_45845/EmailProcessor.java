package school.faang.task_45845;

import school.faang.task_45845.entity.Email;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> print, Function<Email, String> toUpper) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setBody(toUpper.apply(email));
                print.accept(email);
            }
        });
    }
}
