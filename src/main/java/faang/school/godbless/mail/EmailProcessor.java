package faang.school.godbless.mail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> emailPredicate, Consumer<Email> emailConsumer,
                              Function<Email, String> emailFunction) {
        emailList.stream().filter(emailPredicate).peek(emailConsumer).map(emailFunction).collect(Collectors.toList());
    }
}