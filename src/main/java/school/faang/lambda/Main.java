package school.faang.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private final EmailProcessor emailProcessor = new EmailProcessor();
    private final List<Email> emailList = new ArrayList<>();
    private Predicate<Email> predicate;
    Consumer<Email> changeEmail;
    Function<Email, String> transferEmail;

    public static void main(String[] args) {

        Main main = new Main();
        main.initEmailList();
        main.initFunctionalInterfaces();

        main.emailProcessor.processEmails(main.emailList,
                main.predicate,
                main.transferEmail,
                main.changeEmail);

        main.emailList.forEach(System.out::println);
    }

    public void initEmailList() {
        emailList.add(new Email("1: Subject ", "1 Body is less than 30", true));
        emailList.add(new Email("2: Subject ", "2 Body is more than 30 This is a very long string.", false));
        emailList.add(new Email("3: Subject ", "3 Body is less than 30", true));
    }

    public void initFunctionalInterfaces() {
        predicate = email -> email.getBody().length() < 30;
        changeEmail = email -> email.setBody(email.getBody() + "\n ==== Провел обработку ===");
        transferEmail = email -> {
            email.setBody(email.getBody() + "\n === Преобразовал письмо === ");
            return "=== Окончено преобразование письма:" + email.getSubject();
        };
    }
}