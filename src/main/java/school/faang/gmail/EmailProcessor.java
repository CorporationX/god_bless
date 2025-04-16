package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> filterEmail,
                              Consumer<Email> processingEmail,
                              Function<Email, String> converterEmail) {
        for (Email email : emailList) {
            if (filterEmail.test(email)) {
                String update = converterEmail.apply(email);
                email.setBody(update);
                processingEmail.accept(email);
            }
        }
    }
}
