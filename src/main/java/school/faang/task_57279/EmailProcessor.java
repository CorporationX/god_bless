package school.faang.task_57279;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action,
                              Function<Email, String> transformLetter) {
        checkPredicate(filter);
        checkConsumer(action);
        checkFunction(transformLetter);

        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformLetter.apply(email));
                action.accept(email);
            }
        }
    }

    private void checkPredicate(Predicate<Email> filter) {
        Objects.requireNonNull(filter, "Фильтр не может быть null");
    }

    private void checkConsumer(Consumer<Email> action) {
        Objects.requireNonNull(action, "Обработчик не может быть null");
    }

    private void checkFunction(Function<Email, String> transformLetter) {
        if (transformLetter == null) {
            throw new IllegalArgumentException("Преобразователь не может быть null");
        }
    }
}
