package school.faang.task_45774;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> predicateList(List<Email> emails, Predicate<Email> predicate) {
        return emails.stream()
                .filter(predicate)
                .toList();
    }

    public void consumeList(List<Email> emails, Consumer<Email> consumer) {
        emails.forEach(consumer);
    }

    public void functionList(List<Email> emails, Function<Email, String> function) {
        emails.forEach(email -> email.setBody(function.apply(email)));
    }
}
