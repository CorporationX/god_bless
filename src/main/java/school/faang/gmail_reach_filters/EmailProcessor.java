package school.faang.gmail_reach_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Function<Email, String> signatureFunction,
                                     Consumer<Email> printEmailSubject) {
        return emails.stream()
                .filter(filter)
                .peek(printEmailSubject)
                .map(email -> {
                    email.setBody(signatureFunction.apply(email));
                    return email;
                })
                .toList();
    }
}
