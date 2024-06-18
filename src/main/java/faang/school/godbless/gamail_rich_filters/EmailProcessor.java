package faang.school.godbless.gamail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,                              
                              Consumer<Email> handler,
                              Function<Email, String> reform) {
        for (Email email : emails) {
            filter.test(email);
            reform.apply(email);
            handler.accept(email);
        }
    }
}
