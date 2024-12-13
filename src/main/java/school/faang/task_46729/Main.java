package school.faang.task_46729;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification notification1 = new Notification("sms", " -- смс сообщение");
        Notification notification2 = new Notification("email", " -- меил сообщение");
        Notification notification3 = new Notification("push", " -- пуш сообщение");

        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("отправка по смс" + notification.getMessage()));
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("отправка по email " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("push отправка " + notification.getMessage()));


        notificationManager.sendNotification(notification1);
        notificationManager.sendNotification(notification2);
        notificationManager.sendNotification(notification3);
    }
}
