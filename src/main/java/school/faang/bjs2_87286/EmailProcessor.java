package school.faang.bjs2_87286;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Consumer<Email> process,
                                     Function<Email, String> transform) {
        List<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transform.apply(email));
                process.accept(email);
                result.add(email);
            }
        }
        return result;
    }
}
