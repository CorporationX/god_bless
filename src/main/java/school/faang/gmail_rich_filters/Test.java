package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emailList = List.of(Email.builder().subject("Nigerian Prince").body("You are a prince you win 100000000 dollars")
                .isImportant(true).build(), Email.builder().body("Ololololo").isImportant(true).build(), Email.builder().isImportant(true)
                .body("Hello").subject("Hello").build(), Email.builder().subject("Stupid Joke").isImportant(false).build(), Email.builder()
                .isImportant(false).subject("No theme").body("Goodbye").build());

        Predicate<Email> emailFilter = Email::getIsImportant;

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        Consumer<Email> emailConsumer = email -> System.out.println("Cheked email: " + email.getSubject());

        emailProcessor.processEmails(emailList, emailFilter, toUpperCase, emailConsumer);

        System.out.println();

        emailList.forEach(email -> System.out.println("Email's Theme: " + email.getSubject() + " Important email: " + email.getIsImportant()
                + " Email's body: " + email.getBody()));
    }
}
