package school.faang.sprint2.task46005;

import school.faang.sprint2.task46005.model.Email;
import school.faang.sprint2.task46005.processor.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Реклама окон", "Some Text in body 1", false),
                new Email("Просрочен платеж", "Some Text in body 2", true),
                new Email("Квартиры бесплатно", "Some Text in body 3", false),
                new Email("Срочно выходи на работу", "Some Text in body 4", true),
                new Email("Вам задерживается зп", "Some Text in body 5", false)
        );

        System.out.println("Email list before:");
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println(">>>All emails was filtered, transformed and processed");

        System.out.println("Email list after:");
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
