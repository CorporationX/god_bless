package school.faang.bjs2_34689;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("e-mail",
                (notification) -> System.out.println("Сообщение на электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("ERROR",
                (notification) -> System.out.println("Ошибка: " + notification.getMessage()));
        notificationManager.registerHandler("SMS",
                (notification) -> System.out.println("Получено SMS: " + notification.getMessage()));

        Notification emailNotification = new Notification("e-mail", "Привет, новый пользователь!");
        Notification errorNotification = new Notification("ERROR", "Вы ничего не поняли про лямбды!");
        Notification smsNotification = new Notification("SMS", "Привет, братюня!");
        Notification smsBadNotification = new Notification("SMS", "hello, DuMb AsS )))");
        Notification shoutNotification = new Notification("shout", "Я ТЕ КРИЧУ ВНАТУРЕ!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(errorNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(smsBadNotification);
        notificationManager.sendNotification(shoutNotification);
    }
}


