package faang.school.functionalinterfacesandlambdas.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        if (validData(emails, predicate, consumer, function)) {
            System.out.println("Значение не может быть null");
        } else {
            for (Email email : emails) {
                if (predicate.test(email)) {
                    function.apply(email);
                    consumer.accept(email);
                }
            }
        }
    }

    private boolean validData(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        return emails == null
                || emails.isEmpty()
                || predicate == null
                || consumer == null
                || function == null;

    }
}
