package school.faang.task_46661;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("SMS",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по email: " + notification.getMessage()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("push-уведомления: " + notification.getMessage()));

        Notification smsNotification = new Notification("SMS", "Вы успешно прошли регистрацию!");
        Notification emailNotification = new Notification("email", "Вы успешно восстановили пароль!");
        Notification pushNotification = new Notification("push", "Вы успешно пополнили счет!");
        Notification callNotification = new Notification("Звонок", "Вам доступно новое предложение!");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(callNotification);
    }
}
