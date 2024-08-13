package faang.school.godbless.BJS2_21342;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor
public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Function<Email, String> function, Consumer<Email> consumer) {
        emails.removeIf(predicate);
        emails.forEach(consumer);
        for (Email email : emails) {
            System.out.println(function.apply(email));
        }
    }
}
