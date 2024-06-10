package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> isImportant, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email : emails) {
            isImportant.test(email);
            printEmail.accept(email);
            toUpperCase.apply(email);
        }
    }
}