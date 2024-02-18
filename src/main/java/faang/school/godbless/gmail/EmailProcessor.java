package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emailList.forEach(email -> {
            if (predicate.test(email)) {
                function.apply(email);
                consumer.accept(email);
            }
            else{
                consumer.accept(email);
            }

        });
    }
}
