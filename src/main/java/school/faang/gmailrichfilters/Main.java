package school.faang.gmailrichfilters;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Казино", "Текст письма 3", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Set<String> spamWords = Set.of("казино", "выигрыш");
        Predicate<Email> spamFilter = email -> spamWords.stream().noneMatch(w ->
                email.getSubject().toLowerCase().contains(w));

        Predicate<Email> importantAndNoSpam = importantFilter.and(spamFilter);

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Function<Email, String> upperCaseAndSignature = toUpperCase.andThen(body -> body + " Signature");

        Consumer<Email> printEmail = email -> log.info("Обработано письмо: {}", email.getSubject());

        emailProcessor.processEmails(emails, importantAndNoSpam, upperCaseAndSignature, printEmail);

        emails.forEach(email -> log.info("Тема: {}, Тело письма: {}", email.getSubject(), email.getBody()));
    }
}
