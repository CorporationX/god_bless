package school.faang.bjs2_87300;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        final EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(Subjects.FRIENDS, "Сходим погулять в 18?", false,
                LocalTime.of(17, 13, 49)));
        emails.add(new Email(Subjects.JOB, "Надо сегодня сделать отчет до 19:00", true,
                LocalTime.of(15, 33, 45)));
        emails.add(new Email(Subjects.PARENTS, "Почисти картошку на суп", true,
                LocalTime.of(17, 53, 19)));
        emails.add(new Email(Subjects.FRIENDS, "Привет, как у тебя дела?", false,
                LocalTime.of(11, 10, 27)));
        emails.add(new Email(Subjects.JOB, "Отчет надо сделать в виде презентации", true,
                LocalTime.of(16, 43, 53)));
        emails.add(new Email(Subjects.JOB, "За эту работу полагается день отдыха", false,
                LocalTime.of(21, 3, 38)));

        Consumer<Email> emailConsumer = email ->
                System.out.printf("Письмо с темой %s обработано%n%s%n", email.getSubject(), email.getBody());
        Function<Email, String> emailFunction = email ->
                String.format("%tT -> %s", email.getEmailTime(), email.getBody());

        emailProcessor.processEmails(emails, emailConsumer, emailFunction, email -> !email.isImportant());
        System.out.println("---------------------------------------");
        emailProcessor.processEmails(emails, emailConsumer, emailFunction, Email::isImportant);
        System.out.println("---------------------------------------");
        emailProcessor.processEmails(emails, emailConsumer, emailFunction,
                email -> email.getSubject().equals(Subjects.JOB));
    }
}
