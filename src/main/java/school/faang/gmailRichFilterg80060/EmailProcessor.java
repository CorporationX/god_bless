package school.faang.gmailRichFilterg80060;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> list, Predicate<Email> predicate,
                              Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email : list) {
            if (!predicate.test(email)) {
                continue;
            }
            printEmail.accept(email);
            email.setBody(toUpperCase.apply(email));

        }
    }
}
