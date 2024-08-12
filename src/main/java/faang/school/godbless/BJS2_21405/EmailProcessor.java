package faang.school.godbless.BJS2_21405;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails,
                                     Predicate<Boolean> isImportant,
                                     Consumer<Email> processBody,
                                     Function<String, String> processSubject) {
        Iterator<Email> iterator = emails.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();

            if (!isImportant.test(email.isImportant())) {
                iterator.remove();
            }

            processBody.accept(email);
            String readySubject = processSubject.apply(email.getSubject());
            email.setSubject(readySubject);
        }
    }
}
