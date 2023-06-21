package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailPredicate, Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {
        emails.forEach(emailPredicate::test);
        emails.forEach(emailConsumer);
        emails.forEach(emailFunction::apply);
    }
}