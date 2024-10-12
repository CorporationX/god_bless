package school.faang.BJS2_33676;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filterEmail,
                              Consumer<Email> processEmail, Function<Email,String> modifyEmail) {
        for (Email email : emails) {
            if (filterEmail.test(email)) {
                email.setSubject("Attention!!! " + email.getSubject());
            }
            processEmail.accept(email);
            modifyEmail.apply(email);
        }
    }

    public List<Email> answerEmails(List<Email> emails, Function<Email,Email> answer) {
        List<Email> answeredEmails = new LinkedList<>();
        for (Email email : emails) {
            answeredEmails.add(answer.apply(email));
        }
        return answeredEmails;
    }
}
