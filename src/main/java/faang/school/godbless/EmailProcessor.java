package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public  List<String> processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> handler, Function<Email, String> converter) {
        List<String> emailHandlers = new ArrayList<>();
        for (Email email : emails) {
            if (filter.test(email)) {
                String emailHandler = handler.apply(email);
                String convertedBody = converter.apply(email);
                emailHandlers.add(emailHandler + " " + convertedBody);
            }
        }
        return emailHandlers;
    }
}
