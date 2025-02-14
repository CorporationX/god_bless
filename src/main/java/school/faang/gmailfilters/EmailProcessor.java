package school.faang.gmailfilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> function, Consumer<Email> handler) {
        checkEmails(emails);
        checkFilter(filter);
        checkFunction(function);
        checkHandler(handler);
        for (Email email : emails) {
            if (filter.test(email)) {
                handler.accept(email);
                email.setBody(function.apply(email));
            }
        }
    }

    private void checkEmails(List<Email> emails) {
        Objects.requireNonNull(emails, "Список сообщений не может быть null");
    }

    private void checkFilter(Predicate<Email> filter) {
        Objects.requireNonNull(filter, "Фильтр не может быть null");
    }

    private void checkFunction(Function<Email, String> function) {
        Objects.requireNonNull(function, "Преобразователь не может быть null");
    }

    private void checkHandler(Consumer<Email> handler) {
        Objects.requireNonNull(handler, "Обработчик не может быть null");
    }
}