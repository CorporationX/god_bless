package faang.school.godbless.BJS2_21393;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate, Function<Email, String> emailFunction, Consumer<Email> consumer){
        for (Email email : emails){
            if (predicate.test(email)){
                String transformedEmail = emailFunction.apply(email);
                email = new Email(email.getSubject(), transformedEmail, email.isImportant());
                consumer.accept(email);
            }
        }
    }
}
