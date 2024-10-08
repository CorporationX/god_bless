package school.BJS2_33540;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> list, Predicate<Email> predicate, Function<Email,String> function, Consumer<Email> consumer) {
        for(Email email : list) {
            if(predicate.test(email)) {
                consumer.accept(email);
                String x = function.apply(email);
                email.setBody(x);
            }
        }
    }

}
