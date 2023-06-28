package faang.school.godbless.sprint_3.task_6;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = List.of(new Email("qweeq", "aaasd", true),
                new Email("rer", "hghg", false));
        emailProcessor.processEmails(emails, (email) -> !email.getBody().contains("spam"),
                (email) -> {
                    System.out.println(email.getBody());
                    email.setBody(email.getBody() + "stadivany");
                },
                (email) -> email.getSubject());
    }
}
