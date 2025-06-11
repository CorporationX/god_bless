package school.faang.mailFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> isImportant,
                              Function<Email, String> changeBody, Consumer<Email> handler) {
        for (Email email : emails) {
            if (isImportant.test(email)) {
                String changedBody = changeBody.apply(email);
                email.setBody(changedBody);
                handler.accept(email);
                System.out.println();
            }
        }
    }
}
