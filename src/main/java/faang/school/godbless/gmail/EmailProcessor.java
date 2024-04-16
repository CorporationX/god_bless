package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> emailHandler, Function<Email, String> letterConvertor) {
        emails.stream().filter(filter).peek(email -> email.setBody(letterConvertor.apply(email))).forEach(emailHandler);
    }

}
