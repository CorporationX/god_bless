package school.faang.sprint_2.gmailRich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> emailList, Predicate<Email> importantFilter,
                             Function<Email, String> toUpperCase, Consumer<Email> printEmail) {

        for (Email email : emailList) {
            if (importantFilter.test(email)) {
                email.setBody(toUpperCase.apply(email));
                printEmail.accept(email);
            }
        }
    }
}
