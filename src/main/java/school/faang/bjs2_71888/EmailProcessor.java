package school.faang.bjs2_71888;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> filter(
        List<Email> emails, 
        Predicate<Email> isImportant, 
        Consumer<Email> action, 
        Function<Email, Email> modifyEmail) {        
        return emails.stream()
            .filter(isImportant)
            .map(modifyEmail)
            .peek(action)
            .toList();        
    }
}
