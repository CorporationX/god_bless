package school.faang.task_45820;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static List<Email> messages = new ArrayList<>();

    public static void main(String[] args) {
        messages.add(new Email("Акция", "Скидка 10%", true));
        messages.add(new Email("Музей", "Поход в музей", false));
        messages.add(new Email("Внимание", "Воздушная тревога", true));
        messages.add(new Email("Кино", "Вышло новое кино", false));
        messages.add(new Email("Жена", "Срочно перезвони", true));

        Predicate<Email> filterEmail = email -> email.isImportant();
        String notification = ", прошло проверку!";
        Function<Email, String> examinationEmail = email -> email.getBody() + notification;
        Consumer<Email> sendingEmail = email -> System.out.println("Сообщение на тему "
                + email.getSubject() + " успешно доставлено!");

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(messages, filterEmail, examinationEmail, sendingEmail);

        messages.forEach(email -> System.out.println("Тема: "
                + email.getSubject() + "; сообщение: " + email.getBody()));
    }
}
