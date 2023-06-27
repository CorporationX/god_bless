package main.java.faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> email, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){
        if (email == null || email.isEmpty()){
            throw new IllegalArgumentException("Пустой лист");
        }

        for (Email emailll : email){
            if (predicate.test(emailll)) {
                consumer.accept(emailll);
                function.apply(emailll);
            }
        }
    }
}
