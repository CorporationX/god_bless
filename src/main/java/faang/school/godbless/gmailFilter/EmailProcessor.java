import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email> printEmail, Function<Email, String> toUpperCase){
        for (Email email: emails) {
            importantFilter.test(email);
            printEmail.accept(email);
            toUpperCase.apply(email);
        }
    }
}
