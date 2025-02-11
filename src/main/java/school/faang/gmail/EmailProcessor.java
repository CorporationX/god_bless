package school.faang.gmail;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    private static final String EMPTY_EMAILS_LIST_WARN = "Список писем, переданный в метод proccessEmails пустой";

    public void processEmails(
            @NonNull List<Email> emails,
            @NonNull Predicate<Email> filter,
            @NonNull Function<Email, String> transformer,
            @NonNull Consumer<Email> action
    ) {
        Objects.requireNonNull(emails, "Список email не должен быть null");
        Objects.requireNonNull(filter, "Фильтр не должен быть null");
        Objects.requireNonNull(transformer, "Преобразователь не должен быть null");
        Objects.requireNonNull(action, "Действие не должно быть null");

        if (emails.isEmpty()) {
            log.warn(EMPTY_EMAILS_LIST_WARN);
            return;
        }

        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedEmail = transformer.apply(email);
                email.setBody(transformedEmail);
                action.accept(email);
            }
        }
    }
}