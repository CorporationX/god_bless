package school.faang.email.services;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(
            List<Email> emails,
            Predicate<Email> predicate,
            Function<Email, String> function,
            Consumer<Email> consumer
    ) {
        for (Email email : emails){
            if(!predicate.test(email)){
                String functionBody = function.apply(email);
                email.setBody(functionBody);
                consumer.accept(email);
            }
        }
    }
}
