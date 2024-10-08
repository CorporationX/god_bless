package ru.kraiush.BJS2_33560;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Job offer from Google", "We are happy to offer you to land a Software engineer position", true),
                new Email("Job rejection from Meta", "We are so sorry that we have to reject you to land a Software engineer position", false),
                new Email("Job alert from LinkedIn", "There are several Software engineer positions that can fit you", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Consumer<Email> printEmail = email -> System.out.println("Email is proceeded: " + email.getSubject());

        emailProcessor.processEmail(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody()));
    }
}
