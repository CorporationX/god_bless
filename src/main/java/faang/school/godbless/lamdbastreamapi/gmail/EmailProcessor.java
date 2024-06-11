package faang.school.godbless.lamdbastreamapi.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(
            List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function
    ) {
        emails.forEach(predicate::test);
        emails.forEach(consumer::accept);
        emails.forEach(function::apply);
    }
}
