package faang.school.godbless.MetaUniverse2513;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static final String PUSH = "Push";
    static final String TELEGRAM = "Telegram";
    static final String E_MAIL = "E-Mail";

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println("Sending a push to User's phone: " + notification.getMessage()));
        notificationManager.registerHandler(TELEGRAM, (notification) -> System.out.println("Sending a message to user's TG account: " + notification.getMessage()));
        notificationManager.registerHandler(E_MAIL, (notification) -> System.out.println("Sending an E-mail to User: " + notification.getMessage()));

        Notification test1 = new Notification(PUSH, "Your package is arrived");
        Notification test2 = new Notification(TELEGRAM, "\"Mom\" sent you a message");
        Notification test3 = new Notification(TELEGRAM, "\"Love\" sent you a message");
        Notification test4 = new Notification(E_MAIL, "Don't forget to renew your subscription");
        Notification test5 = new Notification(E_MAIL, "Bad Word");
        Notification test6 = new Notification(E_MAIL, "Good Word");
        Notification test7 = new Notification(PUSH, "    ");
        Notification test8 = new Notification(PUSH, "");
        List<Notification> notificationList = new ArrayList<>(List.of(test1, test2, test3, test4, test5, test6, test7, test8));
        Predicate<Notification> badWordFilter = message -> message.getMessage().contains("Bad Word");
        notificationManager.registerFilter("Bad Word filter", badWordFilter);
        Predicate<Notification> blankMessageFilter = message -> message.getMessage().isEmpty() || message.getMessage().trim().isEmpty();
        notificationManager.registerFilter("Blank message filter", blankMessageFilter);

        for (Notification notification : notificationList) {
            notificationManager.sendNotification(notification);
        }
    }
}