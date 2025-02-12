package school.faang.BJS2_57418;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> isImportant,
                              Function<Email, String> converter, Consumer<Email> handler) {
        for (Email email : emails) {
            if (isImportant.test(email)) {
                converter.apply(email);
                handler.accept(email);
            }
        }
    }
}
