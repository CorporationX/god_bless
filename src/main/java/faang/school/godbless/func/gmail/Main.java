package faang.school.godbless.func.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Job Offer from Google", "We've never met someone like you. Our offer is $300.000", true),
                new Email("Job Offer from Meta", "We've never met someone like you. Our offer is $450.000", true),
                new Email("Job Offer from Пятерочка", "You're kinda nice. Want some beer?", true)
        );

        Predicate<Email> includesSalary = email -> email.body().contains("$");
        Consumer<Email> offerReport = email -> System.out.printf("WOOHOOO! %s%n", email.subject());
        Function<Email, String> offeredSalary = email ->
                email.body().substring(email.body().indexOf("$"), email.body().indexOf("000")).replace('.', 'K');

        Map<String, String> importantBits = emailProcessor.processEmails(emails, includesSalary, offerReport, offeredSalary);

        System.out.println(importantBits);
    }
}
