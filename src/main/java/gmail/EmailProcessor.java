package gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> action, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) {  // 1. Фильтрация писем с помощью Predicate
                String transformedBody = transformer.apply(email);  // 2. Преобразование тела письма с помощью Function
                email.setBody(transformedBody);
                action.accept(email);  // 3. Действие над письмом с помощью Consumer
            }
        }
    }
}
