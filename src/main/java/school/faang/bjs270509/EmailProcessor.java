package school.faang.bjs270509;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> converter) {
        emails.stream()
                .filter(filter)                                         // фильтруем Predicate
                .forEach(email -> {                               // для писем которые прошли проверку
                    String convertedBody = converter.apply(email);   // передали письмо получили Stgring)
                    email.setBody(convertedBody);                    // обновили письмо
                    processor.accept(email);                           // выполняем действие над письмом
                });

    }
}
