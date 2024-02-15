package faang.school.godbless.lambda.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> handler, Function<Email, Email> transformer) {
        for (Email email : emailList) {
            if (predicate.test(email)) {
                handler.accept(email);
                transformer.apply(email);
            }
        }
    }
}
