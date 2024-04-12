package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> processedEmail = new ArrayList<>();
        for (Email email : emails) {
            if (predicate.test(email)) {
                function.apply(email);
                processedEmail.add(email);
            }
            consumer.accept(email);
        }
        return processedEmail;
    }
}
