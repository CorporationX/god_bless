package faang.school.godbless.SecondSprint.BJS2_21420;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predictor, Consumer<Email> consumer, Function<Email, String> function) {
        for (int i = 0; i < emails.size(); i++) {
            if (predictor.test(emails.get(i))) {
                consumer.accept(emails.get(i));
                String string = function.apply(emails.get(i));
                emails.get(i).setBody(string);
            }
        }
    }
}
