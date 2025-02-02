package school.faang.bjs245927;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(List<Email> emailList,
                             Predicate<Email> filterEmail,
                             Function<Email, String> transformationEmail,
                             Consumer<Email> handlerEmail) {

        Iterator<Email> iterator = emailList.iterator();
        while (iterator.hasNext()) {
            if (!filterEmail.test(iterator.next())) {
                iterator.remove();
            }
        }
        for (Email email : emailList) {
            if (filterEmail.test(email)) {
                email.setBody(transformationEmail.apply(email));
                handlerEmail.accept(email);
            }
        }
    }
}