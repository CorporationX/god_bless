package school.faang.sprint2.lambda.gmailfilters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Сбербанк одобрил вам кредит.", true),
                new Email("Спам", "Текст спама", false),
                new Email("Письмо 3", "Текст письма 3", true),
                new Email("Письмо 4", "Текст письма 4.", true),
                new Email("Спам2", "Т-банк предлагает свои услуги", false)
        ));

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        System.out.println("\nCase # 1");
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println("\nCase # 2");
        Predicate<Email> bankWordFilter = email -> email.getBody().toLowerCase().contains("банк");
        Consumer<Email> highlightBankInLargeLetters = email -> email.setBody(email.getBody()
                        .replaceAll("банк", "БАНК"));
        Function<Email, String> topicAndBodyLetter = (email) -> ".............\nТема письма: " + email.getSubject()
                + "\nСодержание письма: " + email.getBody() + "\n---конец письма---";
        emailProcessor.processEmails(emails, bankWordFilter, highlightBankInLargeLetters, topicAndBodyLetter);


    }

}

