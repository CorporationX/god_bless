package Gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){
        emailList.forEach(predicate::test);
        emailList.forEach(consumer);
        emailList.forEach(function::apply);
    }
}
