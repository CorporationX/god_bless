package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){

        for (Email email : emails){
           if (predicate.test(email)) {
               String upperCaseWord = function.apply(email);
               System.out.println(upperCaseWord);
               consumer.accept(email);
           }
        }
    }
}