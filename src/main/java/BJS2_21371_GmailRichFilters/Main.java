package BJS2_21371_GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> stanEmails = Arrays.asList(
                new Email("Mail 1", "Dear Slim, I wrote you, but you still ain't callin", true),
                new Email("Mail 2", "Dear Slim, you still ain't called or wrote, I hope you have a chance",
                        false),
                new Email("Mail last", "Dear Mr. I'm-Too-Good-to-Call-or-Write-My-Fans", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        Consumer<Email> printEmail = email -> System.out.println("Email processed " + email.getSubject());

        EmailProcessor.processEmails(stanEmails, importantFilter, printEmail, toLowerCase);
    }
}
