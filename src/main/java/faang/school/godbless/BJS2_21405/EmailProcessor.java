package faang.school.godbless.BJS2_21405;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static List<Email> processEmails(List<Email> emails,
                                     Predicate<Boolean> isImportant,
                                     Consumer<Email> processBody,
                                     Function<String, String> processSubject) {
        return emails.stream()
                .filter(email -> isImportant.test(email.isImportant()))
                .peek(processBody)
                .peek(email -> {
                    String readySubject = processSubject.apply(email.getSubject());
                    email.setSubject(readySubject);
                })
                .toList();
    }
}
