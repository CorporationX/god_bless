package faang.school.godbless.BJS2_21312;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filtration, Consumer<Email> printerEmail,
                              Function<Email, String> emailConvertion){
        if(emails == null){
            throw new IllegalArgumentException("No emails for filtering");
        }

        emails.forEach(email -> {
            if(filtration.test(email)){
                printerEmail.accept(email);
                email.setBody(emailConvertion.apply(email));
            }
        });
    }
}
