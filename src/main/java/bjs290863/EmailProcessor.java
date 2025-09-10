package bjs290863;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action,
                              Function<Email, String> editor) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String editedMail = editor.apply(email);
                email.setBody(editedMail);
                action.accept(email);
            }
        }
    }
}
