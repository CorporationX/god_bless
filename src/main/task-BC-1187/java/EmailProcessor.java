import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        emailList.stream()
                .filter(predicate::test)
                .peek(consumer::accept)
                .forEach(e -> function.apply(e));


    }
}
