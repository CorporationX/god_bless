package school.faang.gmailrichfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emailList, Predicate<Email> importanceFilter, Function<Email, String> transformFilter, Consumer<Email> actionFilter) {
        List<Email> result = new ArrayList<>();
        emailList.forEach(email -> {
            if (importanceFilter.test(email)) {
                email.setBody(transformFilter.apply(email));
                actionFilter.accept(email);
                result.add(email);
            }
        });
        return result;
    }
}
