package school.faang.task_45909;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Email> listOfEmails = List.of(
                new Email("Встреча", "Встреча в 18 вечера", true),
                new Email("Стим", "игра была успешно приобретена", false),
                new Email("Инстаграм", "18 новых сообщений", false));


        EmailProcessor emailProcessor = new EmailProcessor();

        Function<Email, String> transformer = (email) ->  "[ВАЖНОЕ] " + email.getBody();
        Predicate<Email> filter = (email) -> email.isImportant();
        Consumer<Email> action = email -> System.out.println("Обработанное письмо: " + email.getSubject());

        emailProcessor.processEmails(listOfEmails, filter, transformer, action);


    }
}
