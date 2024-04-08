package gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> emailConsumer, Function<Email, String> emailEditor, Consumer<Email> bodyConsumer){
        for (Email email : emails) {
            emailFilter.test(email);
            emailConsumer.accept(email);
            emailEditor.apply(email);
            bodyConsumer.accept(email);
        }
    }
}
