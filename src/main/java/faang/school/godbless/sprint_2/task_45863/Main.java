package faang.school.godbless.sprint_2.task_45863;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Список входящих писем
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Письмо 1", "Текст письма 1", false));
        emails.add(new Email("Письмо 2", "Текст письма 2", true));
        emails.add(new Email("Спам", "Текст спама", false));

        // Фильтр, который пропускает только важные письма
        Predicate<Email> filterImportantEmails = Email::isImportant;

        // Преобразователь, который добавляет подпись после текста письма
        Function<Email, String > insertSignatureIntoLetter = email -> email.getBody() + " С уважением, Александр Иванов";

        // Обработчик, который выводит тему письма в консоль
        Consumer<Email> printEmail = email -> System.out.println("Письмо обработано: " + email.getSubject());

        // Обработка писем
        emailProcessor.processEmails(emails, filterImportantEmails, insertSignatureIntoLetter, printEmail);

        // Выводит обновленные письма, чтобы убедиться, что изменения сохранились
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
