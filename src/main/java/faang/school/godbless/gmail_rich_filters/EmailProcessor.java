package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails (List<Email> emails,
                              Predicate<Email> filtration,
                              Consumer<Email> processing,
                              Function<Email, String> transformation) {
        for (Email email : emails) {
            System.out.println(filtration.test(email));
            processing.accept(email);
            System.out.println(transformation.apply(email));
        }
    }
}
