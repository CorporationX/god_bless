package school.faang.sprint2.bjs_45804;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filterBy,
                              Function<Email, String> changeEmailBody, Consumer<Email> processEmail) {
        emails.stream()
                .filter(filterBy)
                .forEach(email -> {
                    String newBody = changeEmailBody.apply(email);
                    email.setEmailBody(newBody);
                    processEmail.accept(email);
                });
    }
}
