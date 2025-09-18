package bjs2_88753;

import java.util.*;
import java.util.function.*;

public class EmailProcessor {

    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Consumer<Email> action,
            Function<Email, String> transformer
    ) {
        for (Email email : emails) {
            if (filter.test(email)) { // 1. Фильтрация
                String newBody = transformer.apply(email); // 2. Преобразование
                email.setBody(newBody);
                action.accept(email); // 3. Обработка
            }
        }
    }
}