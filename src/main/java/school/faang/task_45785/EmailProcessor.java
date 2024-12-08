package school.faang.task_45785;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> print,
                              Function<Email, String> map) {
        for (Email email : emails) {
            if (filter.test(email)) {
                map.apply(email);
                print.accept(email);
            }
        }
    }
}
