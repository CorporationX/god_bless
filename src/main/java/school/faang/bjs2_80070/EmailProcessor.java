package school.faang.bjs2_80070;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> emailFilter,
                              Function<Email, String> transformEmail, Consumer<Email> emailHandler) {
        for (Email email : emailList) {
            if (!emailFilter.test(email)) {
                continue;
            }
            String newBody = transformEmail.apply(email);
            email.setBody(newBody);
            emailHandler.accept(email);
        }
    }
}
