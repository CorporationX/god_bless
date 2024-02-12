package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> isImportant, Consumer<Email> consumer, Function<Email, String> function){
        for(Email element : emailList){
            if(isImportant.test(element)){
                System.out.println("ВАЖНО ");
            }
            consumer.accept(element);
            String upperCaseBody = function.apply(element);
            System.out.println("Большими буквами: " + upperCaseBody);
            System.out.println();
        }

    }
}
