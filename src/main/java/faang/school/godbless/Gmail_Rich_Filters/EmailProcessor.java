package faang.school.godbless.Gmail_Rich_Filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailsList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){
        for (Email email: emailsList) {
            System.out.println(predicate.test(email));
            consumer.accept(email);
            System.out.println(function.apply(email));
        }
    }
}
