package school.faang.gmail_rich_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        //List of incoming emails
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Email 1 text", false),
                new Email("Email 2", "Email 2 text", true),
                new Email("Spam", "Spam text", false)
        );

        //Filter to filter only important emails
        Predicate<Email> importantFilter = email -> email.isImportant();
        //Processor to print out emails Subject to console
        Consumer<Email> printEmail = email -> System.out.println("Processed email: " + email.getSubject());
        //Converter to format the email text to UpperCase
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        //Processing emails
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        //Printing out emails to make sure changes are in place
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + " Email body: " + email.getBody()));
    }

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> action, Function<Email, String> transformer) {
        for (Email email : emails) {
            if (filter.test(email)) { //Filtering with Predicate
                String transformedBody = transformer.apply(email);//Converting email body using Function
                email.setBody(transformedBody);//Saving changed email body
                action.accept(email);//Action with Consumer
            }
        }
    }
}