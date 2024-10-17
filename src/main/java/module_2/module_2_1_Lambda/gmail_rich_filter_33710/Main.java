package module_2.module_2_1_Lambda.gmail_rich_filter_33710;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = List.of(
          new Email("Письмо 1","Текст письма 1", false),
          new Email("Письмо 2","Text mail 2", true),
          new Email("Письмо 3","Текст письма 3", false),
          new Email("Письмо 4","Текст письма 4", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter,printEmail,toUpperCase);

        emails.forEach(email -> System.out.println(email.toString()));

    }
}
