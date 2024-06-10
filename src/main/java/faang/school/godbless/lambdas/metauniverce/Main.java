package faang.school.godbless.lambdas.metauniverce;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification ->
                System.out.println("Уведомление через email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification ->
                System.out.println("Уведомление по СМС: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification ->
                System.out.println("Push-уведомление в приложении: " + notification.getMessage()));

        notificationManager.sendNotification(new Notification("email", "Сообщение 1"));
        notificationManager.sendNotification(new Notification("email", "Сообщение 2"));
        notificationManager.sendNotification(new Notification("sms", "Сообщение 3"));
        notificationManager.sendNotification(new Notification("push", "Сообщение 4"));
    }
}
