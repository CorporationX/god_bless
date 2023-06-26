package faang.school.godbless.lambda.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer,
                              Function<Email, String> function) {
        if (emailList == null) {
            throw new IllegalArgumentException("Переданный список равен null!");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Метод для фильтрации писем равен null!");
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Метод для обработки писем равен null!");
        }
        if (function == null) {
            throw new IllegalArgumentException("Метод для преобразования писем равен null!");
        }
        for (Email email: emailList) {
            email.setImportant(predicate.test(email));
            consumer.accept(email);
            email.setBody(function.apply(email));
        }
    }
}
