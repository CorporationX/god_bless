package school.faang.mailFilters;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MailFilterTesting {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Промоакция", "Скидка на технику", false),
                new Email("Оффер", "Мы рады взять вас в команду", true),
                new Email("Спам", "10000 рублей за регистрацию", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Название письма: " + email.getSubject() +
                "\nТекст письма: " + email.getBody());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
    }
}
