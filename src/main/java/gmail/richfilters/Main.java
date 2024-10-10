package gmail.richfilters;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 Протестируйте систему, обрабатывая несколько писем и выводя результаты в консоль.
* */
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо номер один", "Текст в письме номер один", false),
                new Email("Письмо номер два", "Текст в письме номер два", true),
                new Email("Примите участие в акции", "Два по цене трёх", false),
                new Email("Примите участие в акции", "Три по цене двух", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Письмо " + email.getSubject() + " обработано.");

        Function<Email, String> bodyToUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> bodyToLowerCase = email -> email.getSubject().toLowerCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, bodyToUpperCase);

        emails.forEach(email -> System.out.println("-> Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

        emailProcessor.processEmails(emails, importantFilter.negate(), printEmail, bodyToLowerCase);

        emails.forEach(email -> System.out.println("-> Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }

}
