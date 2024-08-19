package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email,String> function){
        emails.stream().filter(predicate).peek(consumer).map(function).forEach(System.out::println);
    }
}
