package faang.school.godbless.BJS210222;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Курьер", notification ->
                System.out.println("Отправка гонцом: " + notification.getMessage()));
        notificationManager.registerHandler("Голубиная почта", notification ->
                System.out.println("Отправка голубем: " + notification.getMessage()));
        notificationManager.registerHandler("Почта РФ", notification ->
                System.out.println("Отправка почтой РФ: " + notification.getMessage()));

        Notification courierNotification = new Notification("Курьер",
                "Ваш пароль успешно отправлен");
        Notification pigeonNotification = new Notification("Голубиная почта",
                "Ваши документы успешно отправлены в выбранную страну");
        Notification postNotification = new Notification("Почта РФ",
                "Ваша покупка скоро будет у Вас");

        notificationManager.sendNotification(courierNotification);
        notificationManager.sendNotification(pigeonNotification);
        notificationManager.sendNotification(postNotification);

        notificationManager.addFilter("No banditos",
                notification -> !notification.getMessage().contains("бандит"));
        notificationManager.addFilter("Just little business",
                notification -> !notification.getMessage().contains("конкурент"));

        Notification peredachaNotification = new Notification("Курьер",
                "Ваша передача скоро будет передана бандитом Вашей маме");
        Notification competitorNotification = new Notification("Курьер",
                "Ваш конкурент скоро проснется с подарком");

        notificationManager.sendNotificationWithFilter(peredachaNotification);
        notificationManager.sendNotificationWithFilter(competitorNotification);
    }
}
