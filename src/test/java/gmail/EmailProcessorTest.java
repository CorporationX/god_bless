package gmail;

import faang.school.godbless.gmail.Email;
import faang.school.godbless.gmail.EmailProcessor;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailProcessorTest {
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @Test
  public void processEmailsTest() {
    System.setOut(new PrintStream(outputStreamCaptor));
    EmailProcessor emailProcessor = new EmailProcessor();

    // Создание списка входящих писем
    List<Email> emails = Arrays.asList(
        new Email("Письмо 1", "Текст письма 1", false),
        new Email("Письмо 2", "Текст письма 2", true),
        new Email("Спам", "Текст спама", false)
    );

    // Создание фильтров, обработчиков и преобразователей
    Predicate<Email> importantFilter = email -> {
      System.out.println("Predicate");
      return email.isImportant();
    };

    Consumer<Email> printEmail = email -> System.out.println("Printing");
    Function<Email, String> toUpperCase = email -> {
      System.out.println("To upper case");
      return email.getBody().toUpperCase();
    };

    // Обработка писем
    emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

    assertEquals("Predicate\n" +
        "Printing\n" +
        "To upper case\n" +
        "Predicate\n" +
        "Printing\n" +
        "To upper case\n" +
        "Predicate\n" +
        "Printing\n" +
        "To upper case", outputStreamCaptor.toString()
        .trim());
  }
}
