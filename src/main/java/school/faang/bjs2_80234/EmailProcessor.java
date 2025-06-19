package school.faang.bjs2_80234;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList,
                              Predicate<Email> filter,
                              Function<Email, String> bodyTransformer,
                              Consumer<Email> emailConsumer) {
        List<Email> filteredEmails = new ArrayList<>();

        for (Email email : emailList) {
            if (filter.test(email)) {
                filteredEmails.add(email);
            }
        }

        for (Email email : filteredEmails) {
            String newBody = bodyTransformer.apply(email);
            System.out.println(newBody);

            emailConsumer.accept(email);
        }
    }
}
