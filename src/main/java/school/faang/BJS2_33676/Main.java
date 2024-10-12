package school.faang.BJS2_33676;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> filter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> {
            System.out.println("Письмо " + email.getSubject() + " обработано");
        };

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Function<Email, Email> answer = email -> new Email("RE: " + email.getSubject(),
                ">> " + email.getBody() + "\n My answer", email.isImportant());

        emailProcessor.processEmails(emails, filter, printEmail, toUpperCase);
        List<Email> answeredMaiil = emailProcessor.answerEmails(emails,answer);

        System.out.println();
        for(Email email : answeredMaiil) {
            System.out.println(email);
        }
    }
}
