package school.faang.task_45820;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> message, Predicate<Email> filter,
                              Function<Email, String> examination, Consumer<Email> sending) {
        if (filter == null && examination == null && sending == null) {
            System.out.println("Ошибка фильтрации сообщений!, попробуйте применить другой фильтр");
        } else {
            for (Email emails : message) {
                if (filter.test(emails)) {
                    String transformedBody = examination.apply(emails);
                    emails.setBody(transformedBody);
                    sending.accept(emails);
                }
            }
        }
    }
}
