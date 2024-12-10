package school.faang.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> checker,
                              Function<Email, String> converter, Consumer<Email> printer) {
        for (Email email : emailList) {
            if (checker.test(email.isImportant())) {

            }
        }

    }
}
