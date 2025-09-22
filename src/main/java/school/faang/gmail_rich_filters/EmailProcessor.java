package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Проект: god_bless
 * Класс EmailProcessor
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> converter, Consumer<Email> processor) {
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(converter.apply(email));
                processor.accept(email);
            }
        }
    }
}