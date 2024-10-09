package school.faang.sprint_2.bjs2_33617;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> printer,
                              Function<Email, String> bodyChanger) {
        emails.forEach(email -> {
            if (filter.test(email)) {
                String changedBody = bodyChanger.apply(email);
                email.setBody(changedBody);
                printer.accept(email);
            }
        });
    }
}
