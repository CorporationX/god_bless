package faang.school.godbless.lambdas.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public <T> List<T> processEmails(List<Email> emailList, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, T> function) {
        return emailList.stream()
                .filter(predicate)
                .peek(consumer)
                .map(function)
                .collect(Collectors.toList());
    }
}
