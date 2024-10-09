package Meta;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification emailNotification = new Notification("email", "email messege badcontent");
        Notification smsNotification = new Notification("sms", "sms messege");
        Function<String, String> filterFunction = (messageFromFilter) -> {
            if (messageFromFilter.contains("badcontent")) {
                return "**********";
            } else {
                return messageFromFilter;
            }
        };

        notificationManager.registerHandler("email", (notification ->
                System.out.println("Text  " + notification.getType() + " " + notification.getMessage())));
        notificationManager.registerHandler("sms", (notification ->
                System.out.println("Sms text  " + notification.getType() + " " + notification.getMessage())));
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.filter(emailNotification.getMessage(), filterFunction);
    }
}




