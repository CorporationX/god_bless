package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> listEmail,
                                     Predicate<Email> filterEmail,
                                     Function<Email, String> transformationEmail,
                                     Consumer<Email> processingEmail) {
        return listEmail.stream()
                .filter(filterEmail)
                .peek(email -> email.setBody(transformationEmail.apply(email)))
                .peek(processingEmail)
                .toList();
    }
}