package gmail.filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList,
                              Predicate<Email> filter, Consumer<Email> consumer,
                              Function<Email, String> function) {

        emailList.forEach(email -> {
            filter.test(email);
            consumer.accept(email);
            function.apply(email);
        });
    }
}
