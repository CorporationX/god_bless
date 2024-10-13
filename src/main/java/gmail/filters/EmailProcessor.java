package gmail.filters;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> isImportantFilterFunction,
                              Function<Email, String> convertBodyFunction, Consumer<Email> processEmailFunction) {
        for (Email email : emails) {
            if (isImportantFilterFunction.test(email)) {
                email.setBody(convertBodyFunction.apply(email));
                processEmailFunction.accept(email);
            }
        }
    }
}
