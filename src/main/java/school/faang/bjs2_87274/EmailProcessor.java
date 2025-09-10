package school.faang.bjs2_87274;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private EmailProcessor() {

    }

    public static void processEmails(List<Email> emailList,
                                     Predicate<Email> filter,
                                     Function<Email, String> toUpperCase,
                                     Consumer<Email> handler) {
        for (Email email : emailList) {
            if (filter.test(email)) {
                email.setBody(toUpperCase.apply(email));
                handler.accept(email);
            }
        }
    }
}