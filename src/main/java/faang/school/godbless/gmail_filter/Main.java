package faang.school.godbless.gmail_filter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emailList = List.of(
                new Email("Email-1", " Something in the email-1 ", true),
                new Email("Email-2", " Something in the email-2", true),
                new Email("Email-3", " Something in the email-3", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println(" Processed: " + email.getSubject());
        Function<Email, Email> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };

        emailProcessor.processEmails(emailList, importantFilter, printEmail, toUpperCase);

    }

}
