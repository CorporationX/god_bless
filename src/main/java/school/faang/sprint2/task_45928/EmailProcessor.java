package school.faang.sprint2.task_45928;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> subjectHandler, Function<Email, String> bodyHandler) {
        for (int i = 0; i < emails.size() - 1; i++) {
            if (!filter.test(emails.get(i))) {
                emails.remove(emails.get(i));
            }
            subjectHandler.accept(emails.get(i));
            System.out.println(emails.get(i).getBody());
            bodyHandler.apply(emails.get(i));
        }
        // Цикл сделан, через i, потому что в ином случае
        // Email превращается в Iterator и изменить коллекцию не удается
    }
}
