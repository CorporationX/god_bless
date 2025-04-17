package school.faang.bjs2_71888;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(
        List<Email> emails, 
        Predicate<Email> isImportant, 
        Consumer<Email> action, 
        Function<Email, String> modifyEmailFunction) {
        List<Email> filteredEmails = new ArrayList<>();
        
        for (Email email : emails) {
            if (isImportant.test(email)) {
                filteredEmails.add(email);
            }
        }

        for (Email email : filteredEmails) {
            email.setBody(modifyEmailFunction.apply(email));
        }
        
        for (Email email : filteredEmails) {
            action.accept(email);
        }
        
        return emails;
    }
}
