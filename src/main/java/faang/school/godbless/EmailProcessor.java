package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails (List<Email> emailList, Predicate<Email> filterEmailPredicate,
                               Consumer<Email> letterProcessingConsum,
                               Function<Email, String> letterConversionFunc) {
        for (Email email : emailList) {
            filterEmailPredicate.test(email);
            letterProcessingConsum.accept(email);
            letterConversionFunc.apply(email);
        }
    }
}
