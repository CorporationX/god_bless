package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> predicate,
                              Consumer<Email> consumerEmail,
                              Function<Email, String> functionEmail) {
        for (Email emails : emailList) {
            if (predicate.test(emails)) {
                String update = functionEmail.apply(emails);
                emails.setBody(update);
                consumerEmail.accept(emails);
            }
        }
    }
}
