package school.faang.gmail_filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Function<Email, String>  function, Consumer<Email> consumer) {
        List<Email> resultList = new ArrayList<>();
        emails.forEach(email -> {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                resultList.add(email);
            }
            consumer.accept(email);
        });
        return resultList;
    }
}
