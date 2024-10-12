package school.faang.gmailrichfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
                                     Function<Email, String> function) {

        List<Email> filteredEmailList = new ArrayList<>();

        for (Email email : emails) {
            if (predicate.test(email)) {
                String refactoredMessage = function.apply(email);
                email.setBody(refactoredMessage);
                consumer.accept(email);
                filteredEmailList.add(email);
            }
        }
        return filteredEmailList;
    }
}


