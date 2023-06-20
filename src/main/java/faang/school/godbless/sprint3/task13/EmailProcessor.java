package faang.school.godbless.sprint3.task13;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {
        if (emails.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым!");
        }
        if (consumer == null || predicate == null || function == null) {
            throw new NullPointerException("Функциональные интерфейсы не могут быть пустыми!");
        }
        for (Email email : emails) {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        }
    }
}
