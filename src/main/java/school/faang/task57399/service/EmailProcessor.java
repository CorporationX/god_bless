package school.faang.task57399.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter) {
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        List<Email> result = new ArrayList<>();
        for (Email email:emails) {
            if (filter.test(email)) {
                String transformBody = toUpperCase.apply(email);
                email.setBody(transformBody);
                toUpperCase.apply(email);
                result.add(email);
            }
        }
        return result;
    }
}
