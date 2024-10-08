package org.example.service.googleRichFilter;

import org.example.model.googleRichFilter.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Function<Email, String> convert,
                                     Consumer<Email> process) {
        for(Email email : emails){
            if(filter.test(email)){
                email.setBody(convert.apply(email));
                process.accept(email);
            }
        }
    }

    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("subject1", "body1", false),
                new Email("subject2", "body2", false),
                new Email("subject3", "body3", true),
                new Email("subject4", "body4", true)
        );

        Predicate<Email> unimportantFilter = email -> !email.isImportant();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Email processed: " + email.getSubject());

        processEmails(emails, unimportantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Unimportant email subject: " + email.getSubject() + ", body: " + email.getBody()));
    }
}
