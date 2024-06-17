package faang.school.godbless.lambda.emailHandler;

import lombok.Data;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Consumer<String> emailHandler,
                              Function<Email, String> emailFunction) {
        emails.stream()
                .filter(emailFilter)
                .map(emailFunction)
                .forEach(emailHandler);
    }
}
