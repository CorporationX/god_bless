package faang.school.godbless.lambda.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer,
                              Function<Email, String> function) {
        List<Email> result = new ArrayList<>();
        for (Email email : emailList) {
            if (predicate.test(email)) {
                String newBody = function.apply(email);
                result.add(new Email(email.getSubject(), newBody, email.isImportant()));
                consumer.accept(email);
            }
        }
        return result;
    }

}
