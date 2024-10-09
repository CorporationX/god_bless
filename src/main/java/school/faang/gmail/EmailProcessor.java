package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class EmailProcessor {

    public void processEmails(List<Email> emailList,
                              Predicate<Email> filterPredicate,
                              Consumer<Email> emailConsumer,
                              Function<Email, String> bodyTransformer) {

        emailList
                .stream()
                .filter(filterPredicate)
                .peek(email -> email.setBody(bodyTransformer.apply(email)))
                .forEach(emailConsumer);
    }
}
