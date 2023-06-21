package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> function) {
        if (emails.isEmpty()) {
            throw new IllegalArgumentException("Список писем пуст");
        }

        List<Email> result = new ArrayList<>();

        emails.forEach(email -> {
            if (filter.test(email)) {
                email.setSubject(function.apply(email));
                handler.accept(email);
                result.add(email);
            }
        });

        return result;
    }
}
