package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email>printEmail, Function<Email, String> toUpperCase){
        for (Email email : emails){
            if (importantFilter.test(email)) {
                System.out.println("Важное:" + email.getSubject());
                printEmail.accept(email);
                System.out.println(toUpperCase.apply(email));
            }
                else
                System.out.println("Спам:");
        }
    }
}
