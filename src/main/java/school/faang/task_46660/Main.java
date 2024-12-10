package school.faang.task_46660;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("E-mail", (notification -> System.out.println("Send email: "
                + notification.getMessage())));

        manager.registerHandler("Bank", (notification) -> System.out.println("Отправка SMS: "
                + notification.getMessage()));

        manager.registerHandler("Push", (notification) -> System.out.println("Отправка push-уведомления: "
                + notification.getMessage()));

        Notification emailNotification = new Notification("E-mail", "Письмо успешно отправлено");
        Notification bankNotification = new Notification("Bank", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("Push", "На вас подписался пользователь: Maks");

        manager.sendNotification(emailNotification);
        manager.sendNotification(bankNotification);
        manager.sendNotification(pushNotification);
    }
}
