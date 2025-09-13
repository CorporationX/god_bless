package school.faang.bjs2_87270;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Кино", "Джон Уик 5 выйдет в 2026-2027 году", false),
                new Email("Служба Безопасности", "Комендантский час после 8 часов", true),
                new Email("Черная пятница", "Бешеные скидки во всех магазинах", true),
                new Email("Учебное Мероприятие", "День открытых дверей", true),
                new Email("Спам", "Я использовал эту мазь лишь раз и...", false)
        );
        emails.forEach(System.out::println);
        System.out.println();

        Predicate<Email> emailFilter = email -> email.isImportant();

        Consumer<Email> emailProcessor = email -> System.out.println("Обработано письмо " + email.subject());

        Function<Email, Email> emailConverter = email -> new Email(email.subject(),
                email.body() + " - ПРОЧИТАТЬ", true);

        EmailProcessor.processEmails(emails, emailFilter, emailProcessor, emailConverter);
        System.out.println();

        emails.forEach(System.out::println);
    }
}
