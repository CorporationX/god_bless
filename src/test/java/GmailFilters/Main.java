package GmailFilters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Emailprocessor emailprocessor = new Emailprocessor();
        List<Email> letterList = Arrays.asList(
                new Email("Message", "Message text", true),
                new Email("Info", "Info text", true),
                new Email("Spam", "Spam text", false));

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Predicate<Email> filter = email -> email.isImportant();
        Consumer<Email> lenthEmail = email -> System.out.println(email.getSubject() + " letter length" + " = "
                + email.getBody().length());

        emailprocessor.processEmails(letterList, toUpperCase, filter, lenthEmail);

    }
}

