package school.faang.bjs2_33690;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Email emailFromFaangSchool = new Email("Educational platform in FAANG School", "Welcome, beginner!", true);
        Email emailFromJavaRush = new Email("What about JavaRush?", "How about us?", true);

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>();
        emails.add(emailFromFaangSchool);
        emails.add(emailFromJavaRush);

        emailProcessor.processEmails(
                emails,
                email -> email.isImportant(),
                email -> System.out.println(email.getSubject()),
                email -> email.getBody().toUpperCase()
        );

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Mail body: " + email.getBody() + ", Important: " + email.isImportant()));
    }
}
