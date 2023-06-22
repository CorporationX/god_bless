package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> converter){
        for(Email email : emails){
            if(filter.test(email)){
                handler.accept(email);
                String convertedBody = converter.apply(email);
                System.out.println("Преобразованное тело письма: " + convertedBody);
            }
        }
    }
}
