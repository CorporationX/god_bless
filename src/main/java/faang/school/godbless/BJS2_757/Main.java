package faang.school.godbless.BJS2_757;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notification1 = new Notification("sms", "good");
        Notification notification2 = new Notification("email", "how are you?");

        notificationManager.registerHandler("email", notification -> System.out.println(notification.getMessage()+" get from "+notification.getType()));
        notificationManager.registerHandler("sms", notification -> System.out.println(notification.getMessage()+" get from "+notification.getType()));

        notificationManager.sendNotification(notification1);
        notificationManager.sendNotification(notification2);



    }
}
