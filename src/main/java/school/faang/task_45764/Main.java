package school.faang.task_45764;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();


        List<Email> emailList = Arrays.asList(
                new Email("Справка от невролога", "Добрый день, предоставляем вам письмо...", true),
                new Email("Точно не лохотрон", "Поздравляем! Вы выйграли автомобиль!", false),
                new Email("Заявка №19392", "Мы утвердили вашу заявку", true),
                new Email("Сомольев Д.Д.", "Не, мне лень", false),
                new Email("Магазин приколов", "Чек с покупки", false)
        );

        Function<Email, String> transformation = t -> {
            t.setSubject(t.getSubject() + " (ПРОЧ)");
            return t.getSubject();
        };

        Consumer<Email> processing = process -> {
            System.out.println("Документ обработан: " + process.getSubject() + "\n. Тело письма: " + process.getBody());
        };

        emailProcessor.processEmails(emailList,
                new FilterEmail().filter(false),
                transformation,
                processing);

        // Проверяю изменился ли list
        System.out.println("-----------------------------------------------");
        emailList.forEach(System.out::println);
    }


}
