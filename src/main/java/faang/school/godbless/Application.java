package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Store advertisement", "You have been searching a phone, so we gathered several offers for you with a good price off", false),
                new Email("Job appointment", "Hello Bruce, You have been chosen to rule our grocery store for next seven months", true),
                new Email("Spam", "Текст спама", false),
                new Email("You tickets", "Here's your tickets. You can download them or print", true),
                new Email("Spam", "We are leaders at bank industry, and we have the best offer for you", false),
                new Email("Exam result", "Congratulations! you have passed the exam and we give you grant for free education in our university", true)
        );
        Predicate<Email> importantFilter = Email::isImportant;
        Predicate<Email> notImportantFilter = email -> !email.isImportant();
        Consumer<Email> printEmailSubject = email -> System.out.println("Message back to " + email.getSubject());
        Consumer<Email> printEmail = email -> System.out.println("Topic is " + email.getSubject() + " -> " + email.getBody());
        Function<Email, String> upperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> deleteDots = email -> email.getBody().replace(".", "");
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmail(emails, importantFilter, printEmail, upperCase);
    }
}