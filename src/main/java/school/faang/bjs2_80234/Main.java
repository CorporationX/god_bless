package school.faang.bjs2_80234;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Email> emailList = new ArrayList<>(List.of(
                new Email("Скидки в трикотаже", "Скоро распродажа", false),
                new Email("Подозрительные действия", "В ваш аккаунт пытались зайти", true),
                new Email("Сады придонья", "Самый вкусный сок на свете", false)));

        EmailProcessor processor = new EmailProcessor();
        processor.processEmails(
                emailList,
                email -> email.isImportant(),
                email -> "Преобразованное тело: " + email.getBody(),
                email -> log.info("Обработано письмо:" + email.getSubject()));
    }
}
