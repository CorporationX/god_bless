package faang.school.godbless.gmailfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = new ArrayList<>() {{
            add(new Email("First email", "First email text", false));
            add(new Email("Second email", "Second email text", true));
            add(new Email("Third email", "Third email text", false));
        }};
        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Email handled: " + email.getSubject());
        Function<Email, String> toLowerCase = email -> {
            email.setBody(email.getBody().toLowerCase());
            return email.getBody();
        };
        emailProcessor.processEmails(emails, importantFilter, printEmail, toLowerCase);
    }
}
