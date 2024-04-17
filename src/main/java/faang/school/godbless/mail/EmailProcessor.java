package faang.school.godbless.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    List<Email> emails = new ArrayList<>(Arrays.asList(
            new Email("Письмо 1", "Текст письма", true),
            new Email("Письмо 2", "Текст письма", false),
            new Email("Письмо 3", "Текст письма", true),
            new Email("Спам", "Текст письма", false),
            new Email("Письмо 4", "Текст письма", false),
            new Email("Спам", "Текст письма", false)));

    Predicate<Email> spamFilter = email -> email.getSubject() != "Спам";
    Consumer<Email> printEmail = email -> System.out.println(email.getBody());
    Function<Email, String> importantToUpperCase = email -> email.isImportant() ? email.getSubject().toUpperCase() : email.getSubject() + " Неважное письмо" ;

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmail(emailProcessor.emails, emailProcessor.spamFilter, emailProcessor.printEmail,
                emailProcessor.importantToUpperCase);
    }

    public void processEmail(List<Email> emails, Predicate predicate, Consumer consumer, Function function) {
        for (Email email : emails) {
            if(predicate.test(email)) {
                System.out.println(function.apply(email));
                consumer.accept(email);
            }
        }
    }
}
