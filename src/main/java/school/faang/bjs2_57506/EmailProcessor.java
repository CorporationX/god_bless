package school.faang.bjs2_57506;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handler,
                              Function<Email, String> transformation
    ) {
        checkNull(emails, filter, handler, transformation);
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformation.apply(email));
                handler.accept(email);
            }
        }
    }

    private void checkNull(List<Email> emails,
                           Predicate<Email> filter,
                           Consumer<Email> handler,
                           Function<Email, String> transformation
    ) {
        Objects.requireNonNull(emails, "Список писем не должен быть null!");
        Objects.requireNonNull(filter, "Фильтр не должен быть null!");
        Objects.requireNonNull(handler, "Обработчик не должен быть null!");
        Objects.requireNonNull(transformation, "Преобразователь не должен быть null!");
    }
}
