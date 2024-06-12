package faang.school.godbless.lambda;

import lombok.Data;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Consumer<Email> emailHandler,
                              Function<Email, String> emailFunction) {
        emails.stream()
                .filter(emailFilter)
                .peek(emailHandler)
                .forEach(emailFunction::apply);
    }
}
