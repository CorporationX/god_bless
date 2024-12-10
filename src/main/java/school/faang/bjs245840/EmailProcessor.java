package school.faang.bjs245840;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
                              Function<Email, String> function) {
        var filteredEmails = emails.stream().filter(email -> predicate.test(email)).toList();
        filteredEmails.forEach(emailToProcess -> {
            var processedEmail = function.apply(emailToProcess);
            emailToProcess.setBody(processedEmail);
            consumer.accept(emailToProcess);
        });
    }
}
