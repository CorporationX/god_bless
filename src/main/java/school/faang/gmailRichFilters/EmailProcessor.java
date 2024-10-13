package school.faang.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> transformer) {
        for (Email email : emailList) {
            if (filter.test(email)) {
                String newBody = transformer.apply(email);
                email.setBody(newBody);
                action.accept(email);
            }
        }
    }

}
