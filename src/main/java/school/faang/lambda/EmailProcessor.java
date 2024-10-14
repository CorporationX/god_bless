package school.faang.lambda;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList,
                              Predicate<Email> emailPredicate,
                              Function<Email, String> transferEmail,
                              Consumer<Email> changeEmail) {

        emailList.forEach(email -> {
            email.setBody(emailPredicate.test(email)
                    ? email.getBody().toLowerCase(Locale.ROOT)
                    : email.getBody().toUpperCase());

            changeEmail.accept(email);
            System.out.println(transferEmail.apply(email));
        });
    }
}
