package faang.school.godbless.domain.task_Gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        for (Email email : emailList) {
            predicate.test(email);
            consumer.accept(email);
            function.apply(email);
        }
    }
}
