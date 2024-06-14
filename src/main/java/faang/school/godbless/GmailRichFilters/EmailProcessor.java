package faang.school.godbless.GmailRichFilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private List<Email> allEmailsAfterFilter = new ArrayList<>();

    public void processEmails(List<Email> emails, Predicate<Email> isImportant, Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        for (Email email : emails) {
            if (isImportant.test(email)) {
                Email emailAfterFilter = new Email(email.subject(), toUpperCase.apply(email), email.isImportant());
                allEmailsAfterFilter.add(emailAfterFilter);
                printEmail.accept(emailAfterFilter);
                System.out.println(emailAfterFilter.body());
            }
        }
    }
}