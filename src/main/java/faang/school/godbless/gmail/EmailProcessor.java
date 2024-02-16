package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> incomingEmails, Predicate<Email> importantFilter, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email : incomingEmails) {
            boolean isImportant = importantFilter.test( email );
            if (isImportant) {
                printEmail.accept( email );
                toUpperCase.apply( email );
            }
        }
    }
}
