package school.faang.task45761;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = generateEmails();

        emails.forEach(System.out::println);

        emailProcessor.processEmails(emails, email -> email.isImportant(),
                email -> email.getBody().toUpperCase(),
                email -> System.out.println("Письмо обработано: " + email.getSubject()));

        emails.forEach(email -> System.out.println("Тема: "
                + email.getSubject() + ", Тело письма: "
                + email.getBody()));
    }

    private static List<Email> generateEmails() {

        return new ArrayList<>(List.of(
                new Email("Курсовая работа",
                        "Курсовая работа принята",
                        true),
                new Email("Кредит",
                        "Вам был одобрен кредит",
                        false),
                new Email("Вакансия",
                        "Вы были приняты на работу",
                        true)
        ));
    }
}
