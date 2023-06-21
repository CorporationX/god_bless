package faang.school.godbless.kxnvg.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer,
                              Function<Email, String> function) {
        emailList.forEach((email) -> {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        });
    }
}
