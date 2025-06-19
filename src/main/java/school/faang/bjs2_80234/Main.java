package school.faang.bjs2_80234;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Email> emailList = List.of(
                new Email("Скидки в трикотаже", "Скоро распродажа", false),
                new Email("Подозрительные действия", "В ваш аккаунт пытались зайти", true),
                new Email("Сады придонья", "Самый вкусный сок на свете", false));

        EmailProcessor processor = new EmailProcessor();
        processor.processEmails(
                emailList,
                email -> email.isImportant(),
                email -> "Преобразованное тело: " + email.getBody(),
                email -> System.out.println("Обработано письмо:" + email.getSubject()));
    }
}
