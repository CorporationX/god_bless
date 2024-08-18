package faang.school.godbless.dolbahlop.tasks.lambda.GmailRichFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmail(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor, Function<Email, Email> transformer) {
        List<Email> transformedEmails = new ArrayList<>();

        for (Email email : emails) {
            if (filter.test(email)) {
                processor.accept(email);
                Email transformedEmail = transformer.apply(email);
                transformedEmails.add(transformedEmail);
            }
        }
        return transformedEmails;
    }
}
