package faang.school.godbless.module2.gmailrichfilters;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> emailFunction) {
        emails.stream()
                .filter(emailFilter)
                .peek(email -> email.setBody(emailFunction.apply(email)))
                .forEach(emailConsumer);
    }
}
