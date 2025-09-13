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
        emails.add(new Email(Subject.FRIENDS, "Сходим погулять в 18?", false,
                LocalTime.of(17, 13, 49)));
        emails.add(new Email(Subject.JOB, "Надо сегодня сделать отчет до 19:00", true,
                LocalTime.of(15, 33, 45)));
        emails.add(new Email(Subject.PARENTS, "Почисти картошку на суп", true,
                LocalTime.of(17, 53, 19)));
        emails.add(new Email(Subject.FRIENDS, "Привет, как у тебя дела?", false,
                LocalTime.of(11, 10, 27)));
        emails.add(new Email(Subject.JOB, "Отчет надо сделать в виде презентации", true,
                LocalTime.of(16, 43, 53)));
        emails.add(new Email(Subject.JOB, "За эту работу полагается день отдыха", false,
                LocalTime.of(21, 3, 38)));

        Consumer<Email> handler = email ->
                System.out.printf("Письмо с темой %s обработано%n%s%n", email.getSubject(), email.getBody());
        Function<Email, String> converter = email ->
                String.format("%tT -> %s", email.getReceivingTime(), email.getBody());

        emailProcessor.processEmails(emails, handler, converter, email -> !email.isImportant());
        System.out.println("---------------------------------------");
        emailProcessor.processEmails(emails, handler, converter, Email::isImportant);
        System.out.println("---------------------------------------");
        emailProcessor.processEmails(emails, handler, converter,
                email -> email.getSubject().equals(Subject.JOB));
    }
}
