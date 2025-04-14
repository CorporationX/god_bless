package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> listEmail, Predicate<Email> filterEmail,
                                     Function<Email, String> transformationEmail, Consumer<Email> processingEmail) {
        List<Email> newListEmail = new ArrayList<>();
        for (Email email : listEmail) {
            processingEmail.accept(email);
            if (!filterEmail.test(email)) {
                System.out.println("письмо не важное");
                continue;
            }
            transformationEmail.apply(email);
            newListEmail.add(email);
        }
        return newListEmail;
    }
}