package faang.school.godbless.secondSprint.Meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println("Отправляем на почту: "
                + notification.getMessage()));
        notificationManager.registerHandler("call", notification -> System.out.println("Совершаем звонок: "
                + notification.getMessage()));

        Notification emailNotification = new Notification("email", "ТОЛЬКО СЕГОДНЯ ТРУСЫ ADIDAS ЗА " +
                "30 ГРИВЕН, НЕ ПРОПУСТИ ОГРАНИЧЕННОЕ ПРЕДЛОЖЕНИЕ");
        Notification callNotification = new Notification("call","Работаешь на нелюбимой работе за " +
                "228 рублей в год? Не проблема, заходи на 1xbet по ссылочке снизу!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(callNotification);

        notificationManager.registerFilter(notification -> notification.getMessage().contains("ТОЛЬКО СЕГОДНЯ"));
        notificationManager.registerFilter(notification -> notification.getMessage().contains("1xbet"));

        notificationManager.checkNotification(emailNotification);
        notificationManager.checkNotification(callNotification);
    }
}
