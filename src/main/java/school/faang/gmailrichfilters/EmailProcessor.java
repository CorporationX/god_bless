package school.faang.gmailrichfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
                                     Function<Email, String> function) {

        List<Email> filteredByImportant = new ArrayList<>();

        for (Email email : emails) {
            if (predicate.test(email)) {
                String messageInUpperCase = function.apply(email);
                email.setBody(messageInUpperCase);
                consumer.accept(email);
                if (!filteredByImportant.isEmpty() && !filteredByImportant.get(filteredByImportant.size() - 1).isImportant
                        && email.isImportant()) {
                    filteredByImportant.add(filteredByImportant.size() - 1, email);
                }
            } else {
                filteredByImportant.add(email);
            }

        }
        emails.clear();
        emails.addAll(filteredByImportant);
        return emails;
    }
}


