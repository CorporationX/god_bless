package bjs2_88753;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        // Список писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false),
                new Email("Отчет", "финансовый отчет", true)
        );

        // Predicate: фильтр — только важные письма
        Predicate<Email> importantFilter = Email::isImportant;

        // Consumer: обработка — выводим тему письма
        Consumer<Email> printEmail = email ->
                System.out.println("Обработано письмо: " + email.getSubject());

        // Function: преобразователь — переводим тело в верхний регистр
        Function<Email, String> toUpperCase = email ->
                email.getBody().toUpperCase();

        // Запускаем обработку
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        // Проверяем изменения
        System.out.println("\nПосле обработки:");
        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело: " + email.getBody()));
    }
}