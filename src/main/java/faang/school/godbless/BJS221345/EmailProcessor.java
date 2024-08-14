package faang.school.godbless.BJS221345;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> importantFilter, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        emailList.forEach(email -> {
            importantFilter.test(email);
            printEmail.accept(email);
            toUpperCase.apply(email);
        });
    }
}
