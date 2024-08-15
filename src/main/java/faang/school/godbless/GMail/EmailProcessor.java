package faang.school.godbless.GMail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> checkImportant,
                              Consumer<Email> letterProcessing,
                              Function<Email, String> letterTransformation) {

        for (Email email : emails) {
            if (checkImportant.test(email)) {
                letterProcessing.accept(email);
                String transformedEmail = letterTransformation.apply(email);
                System.out.println("Transformed email: " + transformedEmail);
            } else {System.out.println("Not transformed email: " + email);}
        }
    }
}
