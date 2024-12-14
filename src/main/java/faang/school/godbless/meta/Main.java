package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notification1 = new Notification("sms", "Hello Kevin");
        Notification notification2 = new Notification("Telegram", "You very beautiful");
        Notification notification3 = new Notification("email", "Hello Mister minister");
        notificationManager.registerHandler(notification1.getType(), (notification) ->
                System.out.println("Отправка через мобильные сообщения: " + notification.getMessage()));
        notificationManager.registerHandler(notification2.getType(), (notification) ->
                System.out.println("Отправка через телеграмм: " + notification.getMessage()));
        notificationManager.registerHandler(notification3.getType(), (notification) ->
                System.out.println("Отправка через почту: " + notification.getMessage()));
        notificationManager.sendNotification(notification1);
        notificationManager.sendNotification(notification2);
        notificationManager.sendNotification(notification3);
    }
}


