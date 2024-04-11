package faang.school.godbless.BJS2_5285;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<String> processEmails(
            List<Email> emails,
            Predicate<Email> emailPredicate,
            Consumer<Email> emailConsumer,
            Function<Email, String> emailFunction) {

        return emails.stream().filter(emailPredicate).peek(emailConsumer).map(emailFunction).toList();
    }
}
