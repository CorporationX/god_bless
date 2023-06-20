package faang.school.godbless.sprint_3.meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка за номером телефона: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Ваш номер телефона успешно привязан");
        Notification adidas = new Notification("adidas", "Только сегодня можно купить кроссовки adidas по скидке!");
        Notification crack = new Notification("crack.com", "Заходите на наш сайт с самыми новыми читами crack.com");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);

        notificationManager.filteredNotification(notification -> notification.getMessage().contains("adidas"));
        notificationManager.filteredNotification(notification -> notification.getMessage().contains("crack.com"));


        notificationManager.filter(adidas);
        notificationManager.filter(crack);
    }
}
