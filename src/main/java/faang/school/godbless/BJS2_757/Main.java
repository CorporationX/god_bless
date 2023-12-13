package faang.school.godbless.BJS2_757;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification emailNotification = new Notification("email", "new email!");
        Notification messageNotification = new Notification("message", "new message!");

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("you have received a " + notification.getMessage()));
        notificationManager.registerHandler("message", (notification) ->
                System.out.println("you have received a " + notification.getMessage()));
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(messageNotification);


    }
}
