package school.faang.gmail_rich_filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final List<Email> EMAILS = new ArrayList<>();

    public static void main(String[] args) {
        Predicate<Email> filterBYImportant = email -> email.isImportant();
        Predicate<Email> filterSport = email -> email.subject().equals("Sport");
        Predicate<Email> filterCooking = email -> email.subject().equals("Cooking");
        Function<Email, String> bodyWithSubject = email -> email.body() + " Тема: " + email.subject();
        Function<Email, String> bodyWithNews = email -> email.body()
                + " Срочные новости! Ядерная война отменяется! Отменяем санкции!";
        Consumer<Email> printSubject = email -> System.out.println("Тема письма: " + email.subject());
        Consumer<Email> printBody = email -> System.out.println("Содержимое письма: " + email.body());
        EmailProcessor emailProcessor = new EmailProcessor();

        Email firstEmail = new Email("Sport", "Олимпийские игры состоятся!", true);
        Email secondEmail = new Email("Sport", "Мы будем учавствовать в играх", true);
        Email thirdEmail = new Email("Cooking", "Сегодня день мяса. Будем жарить котлеты!", true);
        EMAILS.add(firstEmail);
        EMAILS.add(secondEmail);
        EMAILS.add(thirdEmail);
        List<String> texts = emailProcessor.processEmails(EMAILS, filterCooking, bodyWithNews, printSubject);
        System.out.println("----------");
        System.out.println(texts);
    }
}
