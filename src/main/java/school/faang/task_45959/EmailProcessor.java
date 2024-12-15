package school.faang.task_45959;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private final List<Email> emails = new ArrayList<>();

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformBody,
                              Consumer<Email> processEmail) {
        String body;
        for (Email mail : emails) {
            if (filter.test(mail)) {
                body = transformBody.apply(mail);
                mail.setBody(body);
                processEmail.accept(mail);
            }
        }
    }
}
