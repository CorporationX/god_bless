package school.faang.BJS2_87262;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicateForEmails, Consumer<Email> emailHandler,
                              Function<Email, String> emailBodyTransformer) {

        List<Email> filteredEmails = new ArrayList<>();
        for (Email email : emails) {
            if (email != null && predicateForEmails.test(email)) {
                filteredEmails.add(email);
            }
        }

        filteredEmails.forEach(emailHandler);
        filteredEmails.forEach(emailBodyTransformer::apply);
    }
}