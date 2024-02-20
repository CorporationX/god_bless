package faang.school.godbless.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailsList, Predicate<Email> filter, Consumer<Email> processing, Function<Email, String> transform) {
        for (Email email : emailsList) {
            if (filter.test(email)) {
                System.out.println("----- Важные сообщения: -----");
                processing.accept(email);
                System.out.println("Сообщение: " + transform.apply(email));
            }
        }

        System.out.println("-----------------------------------");

        for (Email email : emailsList) {
            if (filter.test(email)) {
                
            }

        System.out.println("----- Не важные сообщения: -----");
        //            String upperCase = transform.apply(email);
//            System.out.println("Сообщение: " + upperCase);
//            System.out.println();
    }
}
