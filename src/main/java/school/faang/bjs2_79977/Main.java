package school.faang.bjs2_79977;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = List.of(new Email("Чек об оплате", "Чек об оплате во вложении", true),
                                     new Email("Бонусы", "Вам доступны бонусы", false),
                                     new Email("Скидка", "Скидки до 70%! Не пропустите.", false));

        Predicate<Email> importantFilter = email -> email.isImportant();
        Function<Email, String> addSignTransformer = email -> email.getBody().concat(" - Супер магазин");
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, addSignTransformer, printEmail);

        emails.forEach(email ->
                               log.info("Тема: {}, Тело письма: {}", email.getSubject(), email.getBody()));
    }
}
