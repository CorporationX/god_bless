package school.faang.sprint_2.task_45799;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> converter,
                              Consumer<Email> handler) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    email.setBody(converter.apply(email));
                    handler.accept(email);
                });
    }


}
