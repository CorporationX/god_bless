package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main5 {
    public static void main(String args[]){
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emailList = Arrays.asList (
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> isImportant = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Письмо обработано " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emailList, isImportant, printEmail, toUpperCase);
    }
}
