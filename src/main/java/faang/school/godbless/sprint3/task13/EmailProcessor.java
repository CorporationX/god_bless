package faang.school.godbless.sprint3.task13;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {
        if (emails.isEmpty()) {
            throw new NullPointerException("Список не может быть пустым!");
        }
        if (consumer == null || predicate == null || function == null) {
            throw new NullPointerException("Функциональные интерфейсы не могут быть пустыми!");
        }
        for (Email email : emails) {
            System.out.println(predicate.test(email));
            consumer.accept(email);
            System.out.println(function.apply(email));
        }
    }
}
