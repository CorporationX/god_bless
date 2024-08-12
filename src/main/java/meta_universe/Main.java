package meta_universe;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.registerFilter("python-filter", (notification -> notification.getMessage().toLowerCase().contains("python")));

        notificationManager.registerCorrectingHandler("python-corrector", (notification -> {
            notification.setMessage(notification.getMessage().replaceAll("[P|p]ython", "Java"));
            return notification;
        }));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification pythonNotification = new Notification("push", "Вышла новая статья про Python");

        if (notificationManager.filterNotification("python-filter", pythonNotification)) {
            pythonNotification = notificationManager.correctNotification("python-corrector", pythonNotification);
        }

        notificationManager.sendNotification(pythonNotification); //Python заменяется на Java
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
