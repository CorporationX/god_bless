package school.faang.task_45999;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    EmailProcessor emailProcessor = new EmailProcessor();
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {


        for (Email email : emails) {
            if (predicate.test(email)){
                String transBody = function.apply(email);
                email.setBody(transBody);
                consumer.accept(email);


            }
        }

    }
}
