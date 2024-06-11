package faang.school.godbless.bjs2_9334;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  private static final String MESSAGE_PROCESSED = "Обработано письмо: ";
  private static final String SPAM = "Спам";
  private static final String SPAM_MESSAGE = "Обнаружен спам: ";
  private static final String WARING_MESSAGE = "Данный текс может содержать ложную или рекламную информацию: ";

  public static void main(String[] args) {
    EmailProcessor emailProcessor = new EmailProcessor();

    List<Email> emails = Arrays.asList(
        new Email("Письмо 1", "Текст письма 1", false),
        new Email("Письмо 2", "Текст письма 2", true),
        new Email("Спам", "Текст спама", false)
    );

    Predicate<Email> importantFilter = Email::isImportant;
    Predicate<Email> spamFilter = email -> !SPAM.equals(email.subject());
    Predicate<Email> spamEmail = email -> SPAM.equals(email.subject());
    Consumer<Email> printEmail = email -> System.out.println(MESSAGE_PROCESSED + email.subject());
    Consumer<Email> spamMessage = email -> System.out.println(SPAM_MESSAGE + email.subject());
    Function<Email, String> toUpperCase = email -> email.body().toUpperCase();
    Function<Email, String> waringSpam = email -> WARING_MESSAGE.concat(email.body());

    emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    emailProcessor.processEmails(emails, spamFilter, printEmail, toUpperCase);
    emailProcessor.processEmails(emails, spamEmail, spamMessage, waringSpam);

  }

}
