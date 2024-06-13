package faang.school.godbless.func.meta;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("push", (notification) -> notification);

        notificationManager.registerHandler("message", (notification) -> {
            notification.setMessage(notification.getMessage().replace("Instagram", "Meta"));
            return notification;
        });

        Notification pushNotification = new Notification("push", "You have a new subscriber!");
        Notification messageNotification = new Notification("message", "Hey! have you heard about this new Instagram feature?");

        var push = notificationManager.sendNotification(pushNotification);
        var privateMessage = notificationManager.sendNotification(messageNotification);
        System.out.println(push);
        System.out.println(privateMessage);
    }
}
