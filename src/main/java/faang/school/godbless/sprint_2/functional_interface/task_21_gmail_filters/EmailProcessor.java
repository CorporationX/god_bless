package faang.school.godbless.sprint_2.functional_interface.task_21_gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> inputEmails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email e : inputEmails) {
            consumer.accept(e);
            if (predicate.test(e)) {
                String result = function.apply(e);
                System.out.println(result);
            }
        }

    }
}
