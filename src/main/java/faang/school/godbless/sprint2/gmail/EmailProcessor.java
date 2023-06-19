package faang.school.godbless.sprint2.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> email, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){
        email.forEach(predicate::test);
        email.forEach(consumer);
        email.forEach(function::apply);
    }
}
