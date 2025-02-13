package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Function<Email, String> function, Consumer<Email> handler) {
        List<Email> emailList = new ArrayList<>();

        for (Email email : emails) {
            if (Objects.nonNull(email) && predicate.test(email)) {
                emailList.add(email);
            }
        }

        for (Email email : emailList) {
            email.setBody(function.apply(email));
        }

        for (Email email : emailList) {
            handler.accept(email);
        }

        for (Email email : emailList) {
            System.out.println(email);
        }
    }
}