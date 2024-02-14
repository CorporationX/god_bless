package Task5lymbda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor{
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> type){
        for (Email email: emails){
            if(filter.test(email)){
                System.out.println(type.apply(email));
                process.accept(email);
            }
        }
    }
}
