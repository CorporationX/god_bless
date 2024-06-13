package faang.school.godbless.lambdas.metauniverce;

public class Main {
    private static NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        notificationManager.registerHandler("email", notification ->
                System.out.println("Уведомление через email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification ->
                System.out.println("Уведомление по СМС: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification ->
                System.out.println("Push-уведомление в приложении: " + notification.getMessage()));


        // Регистрируем цензор для emailов, чтобы заменять звездочками нецензурные вхождения
        notificationManager.registerCensor("email", notification -> {
            String textToCensure = "censure";
            String message = notification.getMessage();
            int idx = message.toLowerCase().indexOf(textToCensure);
            while (idx != -1) {
                message = message.substring(0, idx)
                        + "[" + "*".repeat(textToCensure.length()) + "]"
                        + message.substring(idx + textToCensure.length());
                idx = message.toLowerCase().indexOf(textToCensure);
            }
            notification.setMessage(message);
            return notification;
        });

        notificationManager.sendNotification(new Notification("email", "Сообщение 1 + censure"));
        notificationManager.sendNotification(new Notification("email", "Сообcensureщение 2 censure"));
        notificationManager.sendNotification(new Notification("sms", "Сообщение 3 + censure"));
        notificationManager.sendNotification(new Notification("push", "Сообщение 4"));
        notificationManager.sendNotification(new Notification("telegram", "Сообщение 5"));
    }
}
