package school.faang.task_45999;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> checkImportant, Consumer<Email> printEmail, Function<Email, String> changeEmail) {

        for (Email email : emails) {
            if (checkImportant.test(email)) {
                String changeBody = changeEmail.apply(email);
                email.setBody(changeBody);
                printEmail.accept(email);
            }
        }
    }
}
